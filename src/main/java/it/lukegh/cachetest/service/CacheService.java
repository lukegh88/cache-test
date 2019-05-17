package it.lukegh.cachetest.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class CacheService {

    public static final String KEY = "cache-key";

    @Cacheable(value = "testCache", key = "#root.target.KEY", unless = "#result == null")
    public String changeMessage() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String text = date.format(formatter);


        int random = (int)(Math.random() * 5 + 1);
        System.out.println("Generated random number -> " + random + " - Time: " + text);
        return "Hello, World! n." + random + " - Time: " + text;
    }

    @CacheEvict(value = "testCache", allEntries = true)
    public String clearCache() {
        return "Cache cleared!";
    }

}
