package com.rory.learnjava8.defaultmethod.override;

/**
 * Created by RoryGao on 16/1/18.
 */
public interface JukeBox {
    default String rock() {
        return "Junke box rock method";
    }
}
