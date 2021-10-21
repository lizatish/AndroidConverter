package com.tishkovets.lab2.unit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface UnitType {

    default List<UnitType> getEnumConstants() {
        UnitType[] values = this.getClass().getEnumConstants();
        return new ArrayList<>(Arrays.asList(values));
    }

    double getKoeff();

    int getPlural();
}
