package com.rory.learnjava8.defaultmethod.override;

/**
 * Created by RoryGao on 16/1/18.
 */
public class MusicalCarriage implements Carriage, JukeBox {

    @Override
    public String rock() {
        return Carriage.super.rock();

    }
}
