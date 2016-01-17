package com.rory.learnjava8.model;

/**
 * Created by RoryGao on 16/1/17.
 */
public class Album {
    private String name;
    private int coutOfSongs;

    public Album(String name, int coutOfSongs) {
        this.name = name;
        this.coutOfSongs = coutOfSongs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoutOfSongs() {
        return coutOfSongs;
    }

    public void setCoutOfSongs(int coutOfSongs) {
        this.coutOfSongs = coutOfSongs;
    }
}
