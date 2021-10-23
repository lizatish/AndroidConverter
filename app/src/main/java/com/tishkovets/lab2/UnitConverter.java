package com.tishkovets.lab2;

import com.tishkovets.lab2.unit.UnitType;

public class UnitConverter {
    private static UnitConverter instance;

    public UnitConverter() {
    }

    public Unit convert(Unit inputType, UnitType outputType){
        double resValue =  inputType.getValue() / inputType.getUnitType().getKoeff() * outputType.getKoeff();
        return new Unit(outputType, resValue);
    }
}