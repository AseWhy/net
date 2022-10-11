package io.github.asewhy.net.commands.platforms.linux.wifi;

import io.github.asewhy.net.commands.config.WiFiScanConfig;
import io.github.asewhy.net.commands.platforms.linux.wifi.support.WiFiScanIterator;
import io.github.asewhy.net.domains.WiFiNetwork;
import io.github.asewhy.net.support.Command;
import org.jetbrains.annotations.NotNull;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class LinuxWIFiScanCommand extends Command<WiFiScanConfig, Stream<WiFiNetwork>> {
    private static final List<String> DEFAULT_ARGS = List.of(
        "--terse",
        "--fields",
        "active,ssid,bssid,mode,chan,freq,signal,security,device",
        "device",
        "wifi",
        "list"
    );

    public LinuxWIFiScanCommand() {
        super("nmcli");
    }

    @Override
    protected List<String> configure(WiFiScanConfig config) {
        if(config == null || config.getNetworkInterface() == null) {
            return DEFAULT_ARGS;
        }

        var newArgs = new ArrayList<>(DEFAULT_ARGS);

        if(config.getNetworkInterface() != null) {
            newArgs.add("ifname");
            newArgs.add(config.getNetworkInterface());
        }

        return newArgs;
    }

    @Override
    protected Stream<WiFiNetwork> result(@NotNull InputStream stream) {
        return StreamSupport.stream(
            Spliterators.spliteratorUnknownSize(new WiFiScanIterator(stream), Spliterator.ORDERED),
            false
        );
    }
}
