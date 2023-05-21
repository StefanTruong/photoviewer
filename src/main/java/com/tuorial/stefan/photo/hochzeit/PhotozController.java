package com.tuorial.stefan.photo.hochzeit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhotozController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }
}
