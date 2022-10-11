package io.github.asewhy.net.commands.platforms.linux.wifi.support;

import io.github.asewhy.net.domains.WiFiNetwork;
import io.github.asewhy.net.support.Helper;
import io.github.asewhy.net.support.WiFiSecureFlags;

import java.io.*;
import java.util.Iterator;

public class WiFiScanIterator implements Iterator<WiFiNetwork> {
    private final BufferedReader reader;
    private String[] args;

    public WiFiScanIterator(InputStream stream) {
        this.reader = new BufferedReader(new InputStreamReader(stream));
    }

    @Override
    public boolean hasNext() {
        try {
            var line = reader.readLine();

            if(line == null) {
                return false;
            }

            var buffer = new String[] { "", "", "", "", "", "", "", "", "" };
            var reader = new StringReader(line);

            int result;
            int prev = -1;
            int marker = 0;

            while((result = reader.read()) != -1) {
                if((char) result == ':' && (char) prev != '\\') {
                    marker += 1;
                } else {
                    buffer[marker] += (char) result;
                }

                prev = result;
            }

            args = buffer;

            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public WiFiNetwork next() {
        var active = Helper.isYesAnswer(args[0]);
        var displayName = args[1];
        var mac = args[2].replace("\\", "");
        var mode = args[3];
        var chanel = Helper.parseInt(args[4]);
        var frequency = Helper.parseInt(args[5]);
        var signal = Helper.parseDouble(args[6]);
        var flags = 0;
        var device = args[8];

        if(args[7].contains("WPA1")) {
            flags |= WiFiSecureFlags.WPA1;
        }

        if(args[7].contains("WPA2")) {
            flags |= WiFiSecureFlags.WPA2;
        }

        return new WiFiNetwork(active, displayName, mac, mode, chanel, frequency, signal, flags, device);
    }
}
