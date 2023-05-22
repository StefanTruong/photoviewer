package com.tuorial.stefan.photo.hochzeit;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//@Component
@Service
public class PhotosService {
    private Map<String, Photo> db = new HashMap<>(){{
        put("1", new Photo("1", "photo1.jpg"));
    }};

    public Collection<Photo> get() {
        return null;
    }

    public Photo get(String id) {
        return null;
    }

    public Photo remove(String id) {
        return null;
    }

    public void save(String id, Photo photo) {
    }
}
