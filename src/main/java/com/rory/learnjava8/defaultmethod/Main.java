package com.rory.learnjava8.defaultmethod;

/**
 * Created by RoryGao on 16/1/18.
 */
public class Main {
    public static void main(String[] args) {
        IPerson person = new PersonImpl();
        person.welcome();
        IPerson person1 = new ChildImpl();
        person1.welcome();
    }
}
