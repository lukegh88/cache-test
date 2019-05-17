package it.lukegh.cachetest.controller;

import it.lukegh.cachetest.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheRestController {

    private CacheService cacheService;

    @GetMapping("go")
    public ResponseEntity<String> mainEntrance() {
        return new ResponseEntity<>(cacheService.changeMessage(), HttpStatus.OK);
    }

    @GetMapping("clearCache")
    public ResponseEntity<String> cleanCache() {
        return new ResponseEntity<>(cacheService.clearCache(), HttpStatus.OK);
    }

    @Autowired
    public void setCacheService(CacheService cacheService) {
        this.cacheService = cacheService;
    }
}
