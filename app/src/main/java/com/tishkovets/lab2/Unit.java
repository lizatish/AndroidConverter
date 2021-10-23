package com.tishkovets.lab2;

import android.content.res.Resources;

import com.tishkovets.lab2.unit.LengthUnit;
import com.tishkovets.lab2.unit.MassUnit;
import com.tishkovets.lab2.unit.UnitType;
import com.tishkovets.lab2.unit.VolumeUnit;
import com.tishkovets.lab2.validation.TextGetter;

import java.util.Objects;

public class Unit {
    private final UnitType unitType;
    private final double value;

    public Unit(UnitType unitType, double value) {
        this.unitType = unitType;
        this.value = value;
    }

    public static Unit fromString(Resources resources, String validateText, int value) {


        for (MassUnit unit : Objects.requireNonNull(MassUnit.class.getEnumConstants())) {
            String trueText = resources.getQuantityString(unit.getPlural(), value, value);
            if (trueText.equals(validateText)) {
                return new Unit(unit, value);
            }
        }

        for (VolumeUnit unit : Objects.requireNonNull(VolumeUnit.class.getEnumConstants())) {
            String trueText = resources.getQuantityString(unit.getPlural(), value, value);
            if (trueText.equals(validateText)) {
                return new Unit(unit, value);
            }
        }

        for (LengthUnit unit : Objects.requireNonNull(LengthUnit.class.getEnumConstants())) {
            String trueText = resources.getQuantityString(unit.getPlural(), value, value);
            if (trueText.equals(validateText)) {
                return new Unit(unit, value);
            }
        }
        return null;
    }


    public String getStringOutput(Resources resource) {
        String doubleToStringOutputVal = TextGetter.getDouble(this.value);
        return resource.getQuantityString(unitType.getPlural(), (int) this.value, doubleToStringOutputVal);
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public double getValue() {
        return value;
    }
}
