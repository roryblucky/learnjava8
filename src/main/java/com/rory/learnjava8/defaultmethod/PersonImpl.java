package com.rory.learnjava8.defaultmethod;

/**
 * Created by RoryGao on 16/1/18.
 */
public class PersonImpl implements IPerson {
    @Override
    public void message(String msg) {
        System.out.println("impl " + msg);
    }

    @Override
    public String getLastMessage() {
        return null;
    }

    /**
     * 重写welcome方法
     */
    @Override
    public void welcome() {
        System.out.println("deafault method overrided by impl");
    }
}
