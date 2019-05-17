package it.lukegh.cachetest.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class CacheService {

    public String changeMessage() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String text = date.format(formatter);


        int random = (int)(Math.random() * 5 + 1);
        System.out.println("Generated random number -> " + random + " - Time: " + text);
        return "Hello, World! n." + random + " - Time: " + text;
    }

}
