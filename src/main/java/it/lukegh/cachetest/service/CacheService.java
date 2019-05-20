package it.lukegh.cachetest.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class CacheService {

    public static final String KEY = "cache-key";

    private String dateTimeRef;

    public void changeMessage() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        dateTimeRef = date.format(formatter);
    }

    @Cacheable(value = "testCache", key = "#root.target.KEY", unless = "#result == null")
    public String buildMessage() {
        int random = (int)(Math.random() * 5 + 1);
        System.out.println("Generated random number -> " + random + " - Time: " + dateTimeRef);
        return "Hello, World! n." + random + " - Time: " + dateTimeRef;
    }

    @CacheEvict(value = "testCache", allEntries = true)
    public String clearCache() {
        return "Cache cleared!";
    }

}
