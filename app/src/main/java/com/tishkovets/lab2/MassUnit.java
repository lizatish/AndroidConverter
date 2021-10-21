package com.tishkovets.lab2;

public enum MassUnit implements Unit {
    KILOGRAM(1, R.plurals.kilograms_plurals),
    POUND(2.205, R.plurals.pounds_plurals),
    OUNCE(35.274, R.plurals.ounce_plurals),
    GROAN(0.1574, R.plurals.groans_plurals);

    private final double koeff;
    private final int plural;

    MassUnit(double value, int plural) {
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