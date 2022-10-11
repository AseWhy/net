package io.github.asewhy.net.commands.factory;

import io.github.asewhy.net.commands.factory.base.ICommandFactory;
import io.github.asewhy.net.commands.platforms.linux.interfaces.LinuxRoutesScanCommand;
import io.github.asewhy.net.commands.support.Platform;
import io.github.asewhy.net.domains.Route;
import io.github.asewhy.net.support.Command;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

public class RouteScanFactory implements ICommandFactory<Object, Stream<Route>> {
    @Override
    public Command<Object, Stream<Route>> create(@NotNull Platform platform) {
        switch (platform) {
            case linux: return new LinuxRoutesScanCommand();
            default: throw new IllegalArgumentException("Platform " + platform + " not supported yet!");
        }
    }
}
