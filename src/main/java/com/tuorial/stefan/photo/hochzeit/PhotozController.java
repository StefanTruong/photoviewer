package com.tuorial.stefan.photo.hochzeit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhotozController {

    private List<Photo> db = List.of(
            new Photo("1", "photo1.jpg"));
    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/photo")
    public List<Photo> get(){
        return db;
    }

    @GetMapping("/photo/{id}")
    public Photo get(@PathVariable String id){
        return Null;
    }
}
