package com.tishkovets.lab2.validation;

public class Validator {

    public Validator() {
    }

    public static boolean isInt(String value) {
        boolean result = false;
        if (value.matches("[-+]?\\d+")) {
            result = true;
        }
        return result;
    }
}


