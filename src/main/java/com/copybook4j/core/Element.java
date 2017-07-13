package com.copybook4j.core;

/**
 * Created by anujjamwal on 11/07/17.
 */
public interface Element {
    Integer level();
    String name();

    interface Test {
        boolean test(String[] tokens, int start);
    }
}
