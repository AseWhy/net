package io.github.asewhy.net.commands.platforms.linux.interfaces.support;

import io.github.asewhy.net.domains.Route;
import io.github.asewhy.net.support.Helper;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Iterator;

public class RouteScanIterator implements Iterator<Route> {
    private final BufferedReader reader;
    private String[] args;

    public RouteScanIterator(InputStream stream) {
        try {
            this.reader = new BufferedReader(new InputStreamReader(stream));
            this.reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean hasNext() {
        try {
            var line = reader.readLine();

            if(line == null) {
                return false;
            }

            var buffer = new String[] { "", "", "", "", "", "", "", "", "", "", "" };
            var reader = new StringReader(line);

            int result;
            int marker = 0;

            while((result = reader.read()) != -1 && marker < 11) {
                if(buffer[marker].isEmpty()) {
                    if(result != ' ' && result != '\t') {
                        buffer[marker] += (char) result;
                    }
                } else {
                    if(result == ' ' || result == '\t') {
                        marker++;
                    } else {
                        buffer[marker] += (char) result;
                    }
                }
            }

            args = buffer;

            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public Route next() {
        var iface = args[0];
        var destination = getHumanReadableAddress(args[1]);
        var gateway = getHumanReadableAddress(args[2]);
        var flags = Helper.parseInt(args[3]);
        var MTU = Helper.parseInt(args[7]);

        try {
            var network = NetworkInterface.getByName(iface);
            var mac = getMacAddress(network.getHardwareAddress());

            return new Route(destination, gateway, network.getName(), network.getDisplayName(), mac, flags, network.getMTU());
        } catch (SocketException e) {
            return new Route(destination, gateway, iface, iface, null, flags, MTU);
        }
    }

    protected String getHumanReadableAddress(String hexedAddress) {
        var result = new StringBuilder();

        for(var i = 8; i >= 2; i -= 2) {
            result.append(Integer.parseInt(hexedAddress.substring(i - 2, i), 16));

            if(i - 2 >= 2) {
                result.append(".");
            }
        }

        return result.toString();
    }

    protected String getMacAddress(byte @NotNull [] macAddress) {
        var result = new StringBuilder();

        for(var i = 0; i < macAddress.length; i++) {
            result.append(String.format("%02X", macAddress[i]));

            if(macAddress.length > i + 1) {
                result.append(":");
            }
        }

        return result.toString();
    }
}
