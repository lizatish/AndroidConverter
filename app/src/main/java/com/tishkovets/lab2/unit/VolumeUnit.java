package com.tishkovets.lab2.unit;

import com.tishkovets.lab2.R;

public enum VolumeUnit implements UnitType {
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

    @Override
    public String toString() {
        switch (this) {
            case GALLON:
                return "в галлоны";
            case QUART:
                return "в кварты";
            case PINT:
                return "в пинты";
            default:
                return "в литры";
        }
    }

    public int getPlural() {
        return plural;
    }

    public double getKoeff() {
        return koeff;
    }
}

