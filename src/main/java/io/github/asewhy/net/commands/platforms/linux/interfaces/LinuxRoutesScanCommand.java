package io.github.asewhy.net.commands.platforms.linux.interfaces;

import io.github.asewhy.net.commands.platforms.linux.interfaces.support.RouteScanIterator;
import io.github.asewhy.net.domains.Route;
import io.github.asewhy.net.support.Command;
import org.jetbrains.annotations.NotNull;

import java.io.InputStream;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class LinuxRoutesScanCommand extends Command<Object, Stream<Route>> {
    private static final List<String> DEFAULT_ARGS = List.of(
        "/proc/net/route"
    );

    public LinuxRoutesScanCommand() {
        super("cat");
    }

    @Override
    protected List<String> configure(Object config) {
        return DEFAULT_ARGS;
    }

    @Override
    protected Stream<Route> result(@NotNull InputStream stream) {
        return StreamSupport.stream(
            Spliterators.spliteratorUnknownSize(new RouteScanIterator(stream), Spliterator.ORDERED),
            false
        );
    }
}
