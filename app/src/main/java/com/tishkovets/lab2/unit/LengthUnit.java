package com.tishkovets.lab2.unit;

import com.tishkovets.lab2.R;

public enum LengthUnit implements UnitType {
    METER(1, R.plurals.meters_plurals),
    INCH(2.205, R.plurals.inches_plurals),
    FOOT(35.274, R.plurals.feet_plurals),
    YARD(0.1574, R.plurals.yards_plurals);

    private final double koeff;
    private final int plural;

    LengthUnit(double value, int plural) {
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