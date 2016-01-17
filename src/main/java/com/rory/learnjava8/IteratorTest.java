package com.rory.learnjava8;

import com.rory.learnjava8.model.Artist;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by RoryGao on 16/1/17.
 */
public class IteratorTest {
    /**
     * 修改代码 改成内部迭代
     */
    public static void test(List<Artist> artists) {
        int totalMembers = 0;
        for (Artist artist : artists) {
            Stream<Artist> members = artist.getMembers().stream();
            totalMembers += members.count();
        }
        System.out.println(totalMembers);
    }

    /**
     * 修改
     */
    public static void test1(List<Artist> artists) {
        long totalMembers = artists.stream().flatMap(artist -> artist.getMembers().stream()).count();
        System.out.println(totalMembers);
    }

    public static void main(String[] args) {
        Artist artist = new Artist("Rory", "China");
        Artist artist1 = new Artist("Rory1", "China");
        Artist artist2 = new Artist("Rory2", "China");
        Artist team = new Artist("Team", "sd");
        Artist team1 = new Artist("Team1", "sd");
        Artist team2 = new Artist("Team2", "sd");
        team.setMembers(Arrays.asList(artist, artist1, artist2));
        team1.setMembers(Arrays.asList(artist, artist1));
        team2.setMembers(Arrays.asList(artist2));

        List<Artist> teams = Arrays.asList(team, team1, team2);

        test(teams);
        test1(teams);
    }
}
