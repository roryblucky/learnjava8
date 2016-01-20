package com.rory.learnjava8.collectors.customcollector;

/**
 * Created by RoryGao on 16/1/20.
 */
public class StringCombiner {//1.8自带StringJoiner 类似功能
    private StringBuilder builder = new StringBuilder();
    private String prefix;
    private String delimiter;
    private String suffix;

    public StringCombiner(String prefix, String delimiter, String suffix) {
        this.prefix = prefix;
        this.delimiter = delimiter;
        this.suffix = suffix;
    }


    public StringCombiner add(String value) {
        if (aseAtStart()) {
            builder.append(prefix);
        } else {
            builder.append(delimiter);
        }
        builder.append(value);
        return this;
    }

    public StringCombiner merge(StringCombiner other) {
        builder.append(other.builder);
        builder.append(suffix);
        return this;
    }

    private boolean aseAtStart() {
        return builder.length() == 0;
    }
}
