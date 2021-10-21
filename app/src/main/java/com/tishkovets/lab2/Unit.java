package com.tishkovets.lab2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Unit {
    double value = 1;

    default List<Unit> getEnumConstants() {
        Unit[] values = this.getClass().getEnumConstants();
        return new ArrayList<>(Arrays.asList(values));
    }
}
