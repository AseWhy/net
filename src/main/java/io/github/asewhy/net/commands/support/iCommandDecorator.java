package io.github.asewhy.net.commands.support;

import io.github.asewhy.net.commands.config.WiFiScanConfig;
import io.github.asewhy.net.domains.Route;
import io.github.asewhy.net.domains.WiFiNetwork;

import java.io.IOException;
import java.util.stream.Stream;

public interface iCommandDecorator {
    Stream<WiFiNetwork> scanWiFi(WiFiScanConfig config) throws IOException;
    Stream<Route> scanRoutes() throws IOException;
}
