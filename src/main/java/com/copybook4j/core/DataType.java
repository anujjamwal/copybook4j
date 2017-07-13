package com.copybook4j.core;

/**
 * Created by anujjamwal on 13/07/17.
 */
public enum DataType {
    X, _9;

    public static DataType lookup(char ch) {
        switch (ch) {
            case 'X': return X;
            case '9': return _9;
        }

        throw new RuntimeException("Invalid Type Character");
    }
}
