package it.lukegh.cachetest.controller;

import it.lukegh.cachetest.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheRestController {

    private CacheService cacheService;

    @GetMapping("go")
    public ResponseEntity<String> mainEntrance() {
        return ResponseEntity.ok(cacheService.buildMessage());
    }

    @GetMapping("set")
    public ResponseEntity<String> setMessage() {
        cacheService.changeMessage();
        return ResponseEntity.ok().build();
    }

    @GetMapping("clearCache")
    public ResponseEntity<String> cleanCache() {
        return ResponseEntity.ok(cacheService.clearCache());
    }

    @Autowired
    public void setCacheService(CacheService cacheService) {
        this.cacheService = cacheService;
    }
}
