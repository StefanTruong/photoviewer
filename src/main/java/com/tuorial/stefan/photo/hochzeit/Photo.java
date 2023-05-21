package com.tuorial.stefan.photo.hochzeit;

public class Photo {

    private String id;
    private String fileName;

    public Photo() {
    }

    public Photo(String id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public String getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setId(String id) {
        this.id = id;
    }


}
