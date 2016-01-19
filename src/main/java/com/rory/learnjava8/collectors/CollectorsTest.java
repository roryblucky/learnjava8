package com.rory.learnjava8.collectors;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by RoryGao on 16/1/19.
 */
public class CollectorsTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 5, 6, 7, 9, 11, 4, 5, 7, 10);
        // toList
        List<Integer> list1 = list.stream().filter(v -> v > 10).collect(Collectors.toList());
        System.out.println(list1);

        // toSet
        Set<Integer> set = list.stream().filter(v -> v > 5).collect(Collectors.toSet());
        System.out.println(set);

        // toOtherCollections
        Set<Integer> set1 = list.stream().filter(v -> v < 10).collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set1);

        // to Value
        Optional<Integer> i = list.stream().collect(Collectors.maxBy((o1, o2) -> o1 - o2));//找到最大值
        //也可以写成
        Optional<Integer> i1 = list.stream().max((o1, o2) -> o1 - o2);

        System.out.println(i.orElse(0) + " " + i1.orElse(0));

        //数据分块
        Map<Boolean, List<Integer>> map = list.stream().collect(Collectors.partitioningBy(value -> value > 5));
        System.out.println(map.get(true));//大于5的数字
        System.out.println(map.get(false));//小于5的数字

        //数据分组
        Map<String, List<Integer>> groupMap = list.stream().collect(Collectors.groupingBy(value -> {
            if (value % 2 == 0) {
                return "偶数";
            }
            return "奇数";
        }));
        System.out.println(groupMap);

        List<String> strList = Arrays.asList("abc", "sss", "Roxsd", "dcsfdsf", "SDDSDA");
        //格式化
        String formatStr = strList.stream().collect(Collectors.joining(",", "{", "}"));
        System.out.println(formatStr);

        /**
         *  组合收集器
         */

        // 计数
        Map<String, Long> groupMap1 = list.stream().collect(Collectors.groupingBy(value -> {
            if (value % 2 == 0) {
                return "偶数";
            }
            return "奇数";
        }, Collectors.counting()));// 奇数 偶数的个数
        System.out.println(groupMap1);

        // 再次mapping --> 找出奇数偶数中大于1的数 其余用0代替

        Map<String, Set<Integer>> setMap = list.stream().collect(Collectors.groupingBy(value -> {
            if (value % 2 == 0) {
                return "偶数";
            }
            return "奇数";
        }, Collectors.mapping(integer -> {
            if (integer > 1) return integer;
            else return 0;
        }, Collectors.toSet())));

        System.out.println(setMap);

    }
}
