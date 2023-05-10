package ru.zoommax.portfolio.windows;

import java.nio.charset.StandardCharsets;

public enum Loading {
    WAIT ("ожидание"),
    LOAD ("выполняется"),
    DONE ("готово");

    private final String name;

    private Loading(String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }
}
