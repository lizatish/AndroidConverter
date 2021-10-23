package com.tishkovets.lab2;

import com.tishkovets.lab2.unit.UnitType;

public class UnitConverter {
    private static UnitConverter instance;

    private UnitConverter() {
    }

    public Unit convert(Unit inputType, UnitType outputType){
        double resValue =  inputType.getValue() / inputType.getUnitType().getKoeff() * outputType.getKoeff();
        return new Unit(outputType, resValue);
    }

    public static UnitConverter getInstance()
    {
        if (instance == null)
            instance = new UnitConverter();

        return instance;
    }
}