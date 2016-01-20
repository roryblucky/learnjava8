package com.rory.learnjava8.maptest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by RoryGao on 16/1/20.
 */
public class Maptest {

    private static Map<String, Person> cacheData = new HashMap<>();

    public static void main(String[] args) {
        getPerson();
        getPersonUsingNewFuncOfMap();
        iterateMap();
    }

    /**
     * 假设建立缓存,如果当前map没有对应的数据,则从db中读取
     * 1.8之前的做法
     */
    public static void getPerson() {
        //获取Rory对象
        Person rory = cacheData.get("Rory");
        if (rory == null) {
            rory = getPersonFromDB("Rory");
            cacheData.put("Rory", rory);
        }
        System.out.println(cacheData);
        System.out.println("===========Clear cache Map=======");
        cacheData.clear();
    }

    /**
     * 假设建立缓存,如果当前map没有对应的数据,则从db中读取
     * 1.8做法
     */
    public static void getPersonUsingNewFuncOfMap() {
        //如果当前map获取不到数据,自动put到map中,jdk1.8帮助默认实现了上面的getPerson 方法
        Person rory = cacheData.computeIfAbsent("Rory", name -> getPersonFromDB(name));

        System.out.println(cacheData);

    }

    public static void iterateMap() {
        Map<String, Integer> testMap = new HashMap<>();
        testMap.put("Rory", 18);
        testMap.put("Jennifer", 18);
        testMap.put("Sandeep", 28);

        System.out.println();
        System.out.println("=====1.7 iterate Map====");
        //1.8前遍历方式
        for (Iterator<Map.Entry<String, Integer>> it = testMap.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, Integer> entry = it.next();
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
        }

        System.out.println();
        System.out.println("=====1.8 iterate Map====");
        //1.8遍历方式
        testMap.forEach((key, value) -> {

            System.out.println("key: " + key + " value: " + value);
        });

    }

    /**
     * 测试code 模仿从db中获取数据
     *
     * @return
     */
    private static Person getPersonFromDB(String name) {
        try {
            //等待2s
            System.out.println("Wait 2 seconds....");
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Person(name, 18);
    }

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
