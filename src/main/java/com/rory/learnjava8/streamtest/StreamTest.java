package com.rory.learnjava8.streamtest;

import com.rory.learnjava8.model.Album;
import com.rory.learnjava8.model.Artist;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by RoryGao on 16/1/17.
 */
public class StreamTest {

    public static void main(String[] args) {
        System.out.println(sum(Stream.of(1, 2, 3)));
        System.out.println(getNameAndCountry(Arrays.asList(new Artist("123", "China"), new Artist("23", "USA"))));
        System.out.println(getAlbum(Arrays.asList(new Album("haha", 1), new Album("Test", 4))).size());
    }

    /**
     * 计算流中的和
     *
     * @param numbers
     * @return
     */
    public static int sum(Stream<Integer> numbers) {
        return numbers.reduce(0, (acc, num) -> acc + num);
    }

    /**
     * 返回字符串列表,其中包含艺术家的姓名和国籍
     *
     * @param artists
     * @return
     */
    public static List<String> getNameAndCountry(List<Artist> artists) {
        return artists.stream()
                .map(artist -> artist.getName() + " is from " + artist.getCountry())
                .collect(Collectors.toList());
    }

    /**
     * 返回一个由最多包含3首歌曲的专辑的列表
     *
     * @return
     */
    public static List<Album> getAlbum(List<Album> albums) {
        return albums.stream().filter(album -> album.getCoutOfSongs() <= 3).collect(Collectors.toList());
    }
}
