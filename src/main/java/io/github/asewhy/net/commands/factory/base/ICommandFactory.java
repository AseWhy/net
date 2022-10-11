package io.github.asewhy.net.commands.factory.base;

import io.github.asewhy.net.commands.support.Platform;
import io.github.asewhy.net.support.Command;

public interface ICommandFactory<T, R> {
    public Command<T, R> create(Platform platform);
}
