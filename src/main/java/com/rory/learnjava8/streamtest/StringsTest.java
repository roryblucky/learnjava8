package com.rory.learnjava8.streamtest;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Created by RoryGao on 16/1/17.
 */
public class StringsTest {
    /**
     * 计算一个字符串中小写字母的个数
     *
     * @param value
     */
    public static int findLowerCaseCount(String value) {
        return (int) value.chars().filter(Character::isLowerCase).count();
    }

    public static Optional<String> findMostOfString(List<String> values) {
        if (values == null) {
            return Optional.of("");
        }
        return values.stream().max(Comparator.comparing(str -> findLowerCaseCount(str)));
    }

    public static void main(String[] args) {
        String a = "aaaaaaaaaaaddddd";
        String b = "AAAAAAAAAAAAAAVVMMMMMMMMMMMM";
        String c = "sdsdAaaasdsd";
        System.out.println(findLowerCaseCount(a));
        System.out.println(findLowerCaseCount(b));
        System.out.println(findLowerCaseCount(c));

        System.out.println(findMostOfString(Arrays.asList(a, b, c)).get());
    }

}
