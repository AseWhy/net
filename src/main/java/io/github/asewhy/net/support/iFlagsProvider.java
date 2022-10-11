package io.github.asewhy.net.support;

public interface iFlagsProvider {
    long getFlags();

    /**
     * Проверить имеется ли флаг
     *
     * @param flags битовый флаг для проверки
     * @return true если имеется
     */
    default boolean containsAnyFlags(long flags) {
        return (this.getFlags() & flags) != 0;
    }

    /**
     * Проверить имеется ли флаг
     *
     * @param flags битовый флаг для проверки
     * @return true если имеется
     */
    default boolean containsAllFlags(long flags) {
        return (this.getFlags() & flags) == flags;
    }
}
