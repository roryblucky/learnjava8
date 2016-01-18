package com.rory.learnjava8.defaultmethod.override;

/**
 * Created by RoryGao on 16/1/18.
 */
public interface Carriage {
    default String rock() {
        System.out.println("Carriage rock method");
        return "Carriage rock method";
    }
}
