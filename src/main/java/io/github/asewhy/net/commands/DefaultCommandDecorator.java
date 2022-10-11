package io.github.asewhy.net.commands;

import io.github.asewhy.net.commands.factory.RouteScanFactory;
import io.github.asewhy.net.commands.factory.WiFiScanFactory;
import io.github.asewhy.net.commands.config.WiFiScanConfig;
import io.github.asewhy.net.commands.support.Platform;
import io.github.asewhy.net.commands.support.iCommandDecorator;
import io.github.asewhy.net.domains.Route;
import io.github.asewhy.net.domains.WiFiNetwork;

import java.io.IOException;
import java.util.stream.Stream;

public class DefaultCommandDecorator implements iCommandDecorator {
    private static final WiFiScanFactory WI_FI_SCAN_COMMAND_FACTORY = new WiFiScanFactory();
    private static final RouteScanFactory ROUTE_SCAN_FACTORY = new RouteScanFactory();

    public Stream<WiFiNetwork> scanWiFi(WiFiScanConfig config) throws IOException {
        return WI_FI_SCAN_COMMAND_FACTORY.create(Platform.current()).execute(config);
    }

    public Stream<Route> scanRoutes() throws IOException {
        return ROUTE_SCAN_FACTORY.create(Platform.current()).execute(null);
    }
}
