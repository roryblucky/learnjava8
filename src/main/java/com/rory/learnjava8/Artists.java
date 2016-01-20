package com.rory.learnjava8;

import com.rory.learnjava8.model.Artist;

import java.util.List;
import java.util.Optional;

/**
 * Created by RoryGao on 16/1/18.
 */
public class Artists {
    //使用optional对象
    private List<Artist> artists;

    public Artists(List<Artist> artists) {
        this.artists = artists;
    }

    public Optional<Artist> getArtist(int index) {
        if (index < 0 || index >= artists.size()) {
            return Optional.empty();
        }
        return Optional.of(artists.get(index));
    }

    public String getArtistName(int index) {
        Optional<Artist> artistOptional = getArtist(index);
        return artistOptional.map(Artist::getName).orElse("unknown");
    }
}
