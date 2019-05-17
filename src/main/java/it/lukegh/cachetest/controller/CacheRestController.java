package it.lukegh.cachetest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheRestController {

    @GetMapping("go")
    public ResponseEntity<String> mainEntrance() {
        return new ResponseEntity<String>("Hello, World!", HttpStatus.OK);
    }

}
