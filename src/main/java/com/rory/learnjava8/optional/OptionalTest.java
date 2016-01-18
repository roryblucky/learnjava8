package com.rory.learnjava8.optional;

import java.util.Optional;

/**
 * Created by RoryGao on 16/1/18.
 */
public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("a");
        Optional<String> emptyOptional = Optional.empty();

        String s = optional.orElse("it's empty");
        String emptyStr = emptyOptional.orElse("empty");
        String supplierStr = emptyOptional.orElseGet(() -> "supplier empty");


        boolean hasValue = emptyOptional.isPresent();
        emptyOptional.ifPresent(value -> System.out.println(value));
        String notEx, ex = null;
        try {
            notEx = optional.orElseThrow(() -> new Exception("Exception"));
            System.out.println("notEx expected: a; result: " + notEx);
            ex = emptyOptional.orElseThrow(() -> new Exception("Exception"));
        } catch (Exception e) {
            System.out.println("expected: Exception; result: " + e.getMessage());
            System.out.println("ex expected: null; result: " + ex);
        }
        System.out.println("expected: a; result: " + s);
        System.out.println("expected: empty; result: " + emptyStr);
        System.out.println("expected: supplier empty; result: " + supplierStr);
        System.out.println("expected: false; result: " + hasValue);
    }
}
