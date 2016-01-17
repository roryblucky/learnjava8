package com.rory.learnjava8.model;

import java.util.List;

/**
 * Created by RoryGao on 16/1/17.
 */
public class Artist {
    private String name;
    private String country;
    private List<Artist> members;

    public Artist(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public List<Artist> getMembers() {
        return members;
    }

    public void setMembers(List<Artist> members) {
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
