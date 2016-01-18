package com.rory.learnjava8.defaultmethod;

/**
 * Created by RoryGao on 16/1/18.
 */
public interface IPerson {
    static String sayHello() {
        return "Hello";
    }

    void message(String msg);

    default void welcome() {
        message("Hello default method");
    }

    String getLastMessage();
}
