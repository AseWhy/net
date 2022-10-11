package io.github.asewhy.net.commands.factory;

import io.github.asewhy.net.commands.factory.base.ICommandFactory;
import io.github.asewhy.net.commands.platforms.linux.wifi.LinuxWIFiScanCommand;
import io.github.asewhy.net.commands.config.WiFiScanConfig;
import io.github.asewhy.net.commands.support.Platform;
import io.github.asewhy.net.domains.WiFiNetwork;
import io.github.asewhy.net.support.Command;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

public class WiFiScanFactory implements ICommandFactory<WiFiScanConfig, Stream<WiFiNetwork>> {
    @Override
    public Command<WiFiScanConfig, Stream<WiFiNetwork>> create(@NotNull Platform platform) {
        switch (platform) {
            case linux: return new LinuxWIFiScanCommand();
            default: throw new IllegalArgumentException("Platform " + platform + " not supported yet!");
        }
    }
}
