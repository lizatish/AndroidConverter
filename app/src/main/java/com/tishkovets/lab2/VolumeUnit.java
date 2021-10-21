package com.tishkovets.lab2;

public enum VolumeUnit implements Unit{
    LITER(1),
    GALLON(0.264172),
    QUART(1.05669),
    PINT(2.113);

    public final double value;

    VolumeUnit(double value) {
        this.value = value;
    }
}

