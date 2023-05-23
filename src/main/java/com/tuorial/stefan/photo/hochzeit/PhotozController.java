package com.tuorial.stefan.photo.hochzeit;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController
public class PhotozController {

    private final PhotosService photosService;

    public PhotozController(PhotosService photosService) {
        // Hint @Autowired at the variable photosService can replace the Constructor Injection
        this.photosService = photosService;
    }
    // do not use this. db will be handled in the PhotosService
    private List<Photo> db_old = List.of(
            new Photo("1", "photo1.jpg"));

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/photo/")
    public Collection<Photo> get(){
        return photosService.get();
    }

    @GetMapping("/photo/{id}")
    public Photo get(@PathVariable String id){
        Photo photo = photosService.get(id);
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
        Photo photo = photosService.remove(id);
        if(photo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/photo/")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
        /*
        (async function createPhoto() {
          let photo = {"fileName": "post.jpg"};

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
        return photosService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    }


}
