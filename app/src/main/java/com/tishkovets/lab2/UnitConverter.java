package com.tishkovets.lab2;

public class UnitConverter {
    private static UnitConverter instance;

    public UnitConverter() {
    }

    public double convert(Unit inputType, Unit outputType, double value){
        return value / inputType.value * outputType.value;
    }
}