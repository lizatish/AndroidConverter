package com.tishkovets.lab2;

import com.tishkovets.lab2.unit.UnitType;

public class UnitConverter {
    private static UnitConverter instance;

    private UnitConverter() {
    }

    public Unit convert(Unit inputUnit, UnitType outputType) {

        if (inputUnit.getUnitType().getClass() != outputType.getClass()) {
            return null;
        }

        double resValue = inputUnit.getValue() / inputUnit.getUnitType().getKoeff() * outputType.getKoeff();
        return new Unit(outputType, resValue);
    }

    public static UnitConverter getInstance() {
        if (instance == null)
            instance = new UnitConverter();

        return instance;
    }
}