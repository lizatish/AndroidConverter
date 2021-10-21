package com.tishkovets.lab2;

import com.tishkovets.lab2.unit.UnitType;

public class UnitConverter {
    private static UnitConverter instance;

    public UnitConverter() {
    }

    public double convert(UnitType inputType, UnitType outputType, double value){
        return value / inputType.getKoeff() * outputType.getKoeff();
    }
}