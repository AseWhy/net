package io.github.asewhy.net.domains;

import io.github.asewhy.net.support.iFlagsProvider;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Формальная WiFi сеть полученная адаптером
 */
@Getter
@AllArgsConstructor
public class WiFiNetwork implements iFlagsProvider {
    protected final boolean active;
    protected final String displayName;
    protected final String mac;
    protected final String mode;
    protected final int chanel;
    protected final int frequency;
    protected final double signal;
    protected final long flags;
    protected final String interfaceName;

    @Override
    public String toString() {
        return "WiFiNetwork{" +
            "active=" + active +
            ", displayName='" + displayName + '\'' +
            ", mac='" + mac + '\'' +
            ", mode='" + mode + '\'' +
            ", chanel=" + chanel +
            ", frequency=" + frequency +
            ", signal=" + signal +
            ", flags=" + flags +
            ", interfaceName='" + interfaceName + '\'' +
        '}';
    }
}
