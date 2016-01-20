package com.rory.learnjava8.collectors;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by RoryGao on 16/1/20.
 */
public class Practice {
    /**
     * a. 找出最长的字符串,使用收集器和reduce分别实现.
     */

    /**
     * Fibonacci
     */
    static final Map<Integer, Long> map = new HashMap<>();

    /**
     * 收集器实现
     */
    public static void findLongestStr() {
        Stream<String> names = Stream.of("Rory Gao", "Fly", "Rolan", "Alice", "Kris", "Sandeep", "Vineet", "Lakshmi");
        Comparator<String> comparator = Comparator.comparing(t -> t.length());
        String name = names.collect(Collectors.maxBy(comparator)).orElse("Empty!!!!!");
        System.out.println("collectors: " + name);
    }

    /**
     * reduce实现
     */
    public static void findLongestStrRedu() {
        Stream<String> names = Stream.of("Rory Gao", "Fly", "Rolan", "Alice", "Kris", "Sandeep", "Vineet", "Lakshmi");
        Comparator<String> comparator = Comparator.comparing(t -> t.length());
        String name = names.reduce((s1, s2) ->
                comparator.compare(s1, s2) >= 0 ? s1 : s2
        ).orElse("Empty!!!");
        System.out.println("Reduce: " + name);
    }

    /**
     * b. 计算每个单词出现的次数,返回值格式为[a -> 3, b->2, c->11]的map
     */
    public static void countWords() {
        Stream<String> words = Stream.of("Hello", "World", "Java", "Golang", "Python", "Golang", "iOS", "Java");
        Map<String, Long> resultMap = words.collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        System.out.println(resultMap);
    }

    public static void fibonacci() {
        map.put(0, 0l);
        map.put(1, 1l);
        computeFibonacci(10);
        System.out.println(map);
    }

    private static long computeFibonacci(int x) {
        return map.computeIfAbsent(x, n -> computeFibonacci(n - 1) + computeFibonacci(n - 2));
    }


    public static void main(String[] args) {
        findLongestStr();
        findLongestStrRedu();
        countWords();
        fibonacci();
    }
}
