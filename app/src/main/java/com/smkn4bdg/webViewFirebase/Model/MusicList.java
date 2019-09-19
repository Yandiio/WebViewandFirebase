package com.smkn4bdg.webViewFirebase.Model;

public class MusicList {
    String id,name,genre;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public MusicList(String id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }
}
