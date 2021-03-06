package com.tishkovets.lab2.unit;

import com.tishkovets.lab2.R;

public enum MassUnit implements UnitType {
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

    @Override
    public String toString() {
        switch (this) {
            case POUND:
                return "в фунты";
            case OUNCE:
                return "в унции";
            case GROAN:
                return "в стоны";
            default:
                return "в килограммы";
        }
    }

    public int getPlural() {
        return plural;
    }

    public double getKoeff() {
        return koeff;
    }
}