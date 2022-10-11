package io.github.asewhy.net.support;

import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.Set;

public class Helper {
    private static final Set<String> YES_ANSWERS = Set.of("да", "yes");

    public static boolean isYesAnswer(@NotNull String answer) {
        return YES_ANSWERS.contains(answer.toLowerCase(Locale.ROOT));
    }

    /**
     * Безопасно распарсить строку в число, убрав все пробелы
     *
     * @param s строка
     * @return число
     */
    public static double parseDouble(@NotNull String s) {
        var useful = new StringBuilder();

        for(var i = 0; i < s.length(); i++) {
            var current = s.charAt(i);

            if(useful.length() > 0) {
                if(current == '.' || Character.isDigit(current)) {
                    useful.append(current);
                }
            } else if(Character.isDigit(current)) {
                useful.append(current);
            }
        }

        return Double.parseDouble(useful.toString());
    }

    /**
     * Безопасно распарсить строку в число, убрав все пробелы
     *
     * @param s строка
     * @return число
     */
    public static int parseInt(@NotNull String s) {
        var useful = new StringBuilder();

        for(var i = 0; i < s.length(); i++) {
            var current = s.charAt(i);

            if(Character.isDigit(current)) {
                useful.append(current);
            }
        }

        return Integer.parseInt(useful.toString());
    }
}
