package com.tishkovets.lab2;

public enum LengthUnit implements Unit{
    METER(1),
    INCH(2.205),
    FOOT(35.274),
    YARD(0.1574);

    public final double value;

    LengthUnit(double value) {
        this.value = value;
    }
}