package com.tishkovets.lab2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Unit {

    default List<Unit> getEnumConstants() {
        Unit[] values = this.getClass().getEnumConstants();
        return new ArrayList<>(Arrays.asList(values));
    }

    double getKoeff();

    int getPlural();
}
