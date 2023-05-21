package com.tuorial.stefan.photo.hochzeit;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
public class PhotozController {

    private Map<String, Photo> db = new HashMap<>(){{
        put("1", new Photo("1", "photo1.jpg"));
    }};

    private List<Photo> db_old = List.of(
            new Photo("1", "photo1.jpg"));

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/photo/")
    public Collection<Photo> get(){
        return db.values();
    }

    @GetMapping("/photo/{id}")
    public Photo get(@PathVariable String id){
        Photo photo = db.get(id);
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
          await fetch("http://localhost:8080/photo/" + id, {method: "DELETE"})
          })("1")
         */
        Photo photo = db.remove(id);
        if(photo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/photo/")
    public Photo create(@RequestBody Photo photo){
        /*
        (async function createPhoto() {
          let photo = {"filename": "post.jpg"};

          await fetch("http://localhost:8080/photo/", {
                    method: "POST",
                    headers: {
                              "Accept": "application/json",
                              "Content-Type": "application/json"
                    },
                    body: JSON.stringify(photo)
                    })
                    .then(result => result.text())
                    .then(text => alert(text));
        })();
         */

        photo.setId(UUID.randomUUID().toString());
        db.put(photo.getId(), photo);

        return photo;
    }


}
