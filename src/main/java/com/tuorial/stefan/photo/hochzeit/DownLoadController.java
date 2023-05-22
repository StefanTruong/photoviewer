package com.tuorial.stefan.photo.hochzeit;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DownLoadController {

    private final PhotosService photosService;

    public DownLoadController(PhotosService photosService) {
        // Hint @Autowired at the variable photosService can replace the Constructor Injection
        this.photosService = photosService;
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable String id){
        byte[] data = new byte[0];
        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }
}

