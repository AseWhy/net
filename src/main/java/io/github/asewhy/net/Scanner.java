package io.github.asewhy.net;

import io.github.asewhy.net.commands.DefaultCommandDecorator;
import io.github.asewhy.net.commands.config.WiFiScanConfig;
import io.github.asewhy.net.commands.support.iCommandDecorator;
import io.github.asewhy.net.domains.Route;
import io.github.asewhy.net.domains.WiFiNetwork;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class Scanner {
    private final iCommandDecorator commandDecorator;

    public Scanner(iCommandDecorator commandDecorator) {
        this.commandDecorator = commandDecorator;
    }

    public Scanner() {
        this(new DefaultCommandDecorator());
    }

    /**
     * Выполнить сканирование сетей WiFi для текущей платформы
     * <p/>
     * Действие выполняется в текущем поток, и операция довольно долгая
     *
     * @param config конфигурация сканирования
     * @return поток с wifi соединениями
     * @throws IOException при ошибке сканирования
     */
    public Stream<WiFiNetwork> scanWiFi(WiFiScanConfig config) throws IOException {
        return commandDecorator.scanWiFi(config);
    }

    /**
     * Выполнить сканирование сетей WiFi для текущей платформы
     * <p/>
     * Действие выполняется в текущем поток, и операция довольно долгая
     *
     * @return поток с wifi соединениями
     * @throws IOException при ошибке сканирования
     */
    public Stream<WiFiNetwork> scanWiFi() throws IOException {
        return scanWiFi(null);
    }

    /**
     * Получить текущее активное wifi соединение
     * <p/>
     * Действие выполняется в текущем поток, и операция довольно долгая
     *
     * @param config конфигурация сканирования
     * @return опциональное значение текущего wifi соединение
     * @throws IOException при ошибке сканирования
     */
    public Optional<WiFiNetwork> currentWiFi(WiFiScanConfig config) throws IOException {
        return scanWiFi(config).filter(WiFiNetwork::isActive).findFirst();
    }

    /**
     * Получить текущее активное wifi соединение
     * <p/>
     * Действие выполняется в текущем поток, и операция довольно долгая
     *
     * @return опциональное значение текущего wifi соединение
     * @throws IOException при ошибке сканирования
     */
    public Optional<WiFiNetwork> currentWiFi() throws IOException {
        return currentWiFi(null);
    }

    /**
     * Получить все допустимые маршруты для текущего устройства
     *
     * @return поток маршрутов
     * @throws IOException при ошибке сканирования
     */
    public Stream<Route> scanRoutes() throws IOException {
        return commandDecorator.scanRoutes();
    }

    /**
     * Получить все допустимые маршруты для текущего устройства
     *
     * @return поток маршрутов
     * @throws IOException при ошибке сканирования
     */
    public Optional<Route> findRoute(String name) throws IOException {
        return scanRoutes()
            .filter(e -> Objects.equals(name, e.getName()))
        .findFirst();
    }
}
