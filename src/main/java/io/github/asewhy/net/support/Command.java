package io.github.asewhy.net.support;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@AllArgsConstructor
public abstract class Command<T, R> {
    private String name;

    protected abstract List<String> configure(T config);
    protected abstract R result(InputStream stream);

    public R execute(T config) throws IOException {
        return result(
            Runtime.getRuntime()
                .exec(name + " " + String.join(" ", configure(config)))
            .getInputStream()
        );
    }
}
