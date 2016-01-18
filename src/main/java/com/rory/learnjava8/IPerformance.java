package com.rory.learnjava8;

import com.rory.learnjava8.model.Artist;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by RoryGao on 16/1/18.
 */
public interface IPerformance {
    String getName();

    Stream<Artist> getMusicians();

    /**
     * 返回当前乐队的乐队名和乐队成员
     *
     * @return
     */
    default String getAllMusicians() {
        return getName() + getMusicians().map(artist -> artist.getName()).collect(Collectors.toList());
    }
}
