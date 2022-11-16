package me.hsgamer.edublock.rs.test;

import java.net.URI;

public interface UrlSupplier {
    String get(String path);

    default URI getUri(String path) {
        return URI.create(get(path));
    }
}
