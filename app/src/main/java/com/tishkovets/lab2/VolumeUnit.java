package com.tishkovets.lab2;

public enum VolumeUnit implements Unit {
    LITER(1, R.plurals.liters_plurals),
    GALLON(0.264172, R.plurals.gallons_plurals),
    QUART(1.05669, R.plurals.quarts_plurals),
    PINT(2.113, R.plurals.pints_plurals);

    private final double koeff;
    private final int plural;

    VolumeUnit(double value, int plural) {
        this.koeff = value;
        this.plural = plural;
    }

    public int getPlural() {
        return plural;
    }

    public double getKoeff() {
        return koeff;
    }
}

