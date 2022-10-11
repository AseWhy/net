package io.github.asewhy.net.domains;

import io.github.asewhy.net.support.iFlagsProvider;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Формальное базовое подключение
 */
@Getter
@AllArgsConstructor
public class Route implements iFlagsProvider {
    protected final String destination;
    protected final String gateway;
    protected final String name;
    protected final String displayName;
    protected final String mac;
    protected final long flags;
    protected final int MTU;

    public boolean isDefaultRoute() {
        return "0.0.0.0".equals(destination);
    }

    public boolean hasGateWay() {
        return gateway != null && !"0.0.0.0".equals(gateway);
    }

    @Override
    public String toString() {
        return "Route{" +
            "destination='" + destination + '\'' +
            ", gateway='" + gateway + '\'' +
            ", name='" + name + '\'' +
            ", displayName='" + displayName + '\'' +
            ", mac='" + mac + '\'' +
            ", flags=" + flags +
            ", MTU=" + MTU +
        '}';
    }
}
