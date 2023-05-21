package com.tuorial.stefan.photo.hochzeit;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PhotozController {

    private Map<String, Photo> db_new = new HashMap<>(){{
        put("1", new Photo("1", "photo1.jpg"));
    }};

    private List<Photo> db_old = List.of(
            new Photo("1", "photo1.jpg"));

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/photo")
    public Collection<Photo> get(){
        return db_new.values();
    }

    @GetMapping("/photo/{id}")
    public Photo get(@PathVariable String id){
        Photo photo = db_new.get(id);
        if(photo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return photo;
    }


    @DeleteMapping("/photo/{id}")
    public void delete(@PathVariable String id){
        /*
        To execute a delete call from a browser use the console of the browser.
        (async function deletePhoto(id) {
            await fetch('http://localhost:8080/photo/' + id, {method: 'DELETE'})
        })("1");
         */
        Photo photo = db_new.remove(id);
        if(photo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
