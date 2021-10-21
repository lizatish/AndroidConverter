package com.tishkovets.lab2;

public enum MassUnit implements Unit {
    KILOGRAM(1),
    POUND(2.205),
    OUNCE(35.274),
    GROAN(0.1574);

    public final double value;

    MassUnit(double value) {
        this.value = value;
    }
}