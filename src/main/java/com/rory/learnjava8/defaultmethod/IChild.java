package com.rory.learnjava8.defaultmethod;

/**
 * Created by RoryGao on 16/1/18.
 */
public interface IChild extends IPerson {
    @Override
    default void welcome() {
        System.out.println("Child default method");
    }
}
