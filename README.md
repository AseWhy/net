# Net

Простой модуль для работы с сетями и сетевыми интерфейсами. Модуль просто дергает программы которые уже установлены у пользователя
и парсит результат их выполнения.

Весь функционал предоставлен в классе Scanner

## Пример

```java
import io.github.asewhy.net.Scanner;

class Example {
    public static void main(String[] args) {
        var scanner = new Scanner();
        
        // Выводим все интерфейсы которые нашлись
        scanner.scanRoutes().forEach(System.out::println);
        
        // Выводим все найденные wifi сети
        scanner.scanWiFi().forEach(System.out::println);
    }
}
```

## Поддержка

На данный момент поддерживается только OS Linux

| ОС      | Метод      | Поддержка |
|---------|:-----------|:---------:|
| Linux   | scanRoutes |     +     |
| Linux   | scanWiFi   |     +     |
| Windows | scanRoutes |     -     |
| Windows | scanWiFi   |     -     |
| Darwin  | scanRoutes |     -     |
| Darwin  | scanWiFi   |     -     |