package com.tishkovets.lab2.unit;

import com.tishkovets.lab2.R;

public enum LengthUnit implements UnitType {
    METER(1, R.plurals.meters_plurals),
    INCH(39.37, R.plurals.inches_plurals),
    FOOT(3.281, R.plurals.feet_plurals),
    YARD(1.094, R.plurals.yards_plurals);

    private final double koeff;
    private final int plural;

    LengthUnit(double value, int plural) {
        this.koeff = value;
        this.plural = plural;
    }

    @Override
    public String toString() {
        switch (this) {
            case INCH:
                return "в дюймы";
            case FOOT:
                return "в футы";
            case YARD:
                return "в ярды";
            default:
                return "в метры";
        }
    }

    public int getPlural() {
        return plural;
    }

    public double getKoeff() {
        return koeff;
    }
}