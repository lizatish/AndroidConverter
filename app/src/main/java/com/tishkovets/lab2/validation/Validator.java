package com.tishkovets.lab2.validation;

import android.content.res.Resources;

import com.tishkovets.lab2.unit.LengthUnit;
import com.tishkovets.lab2.unit.MassUnit;
import com.tishkovets.lab2.unit.UnitType;
import com.tishkovets.lab2.unit.VolumeUnit;

import java.util.Objects;

public class Validator {

    public Validator() {
    }

    public boolean isInt(String value) {
        boolean result = false;
        if (value.matches("[-+]?\\d+")) {
            result = true;
        }
        return result;
    }

    public UnitType getUnitOrNull(Resources resources, String validateText, int value) {

        for (MassUnit unit : Objects.requireNonNull(MassUnit.class.getEnumConstants())) {
            String trueText = resources.getQuantityString(unit.getPlural(), value, value);
            if (trueText.equals(validateText)) {
                return unit;
            }
        }

        for (VolumeUnit unit : Objects.requireNonNull(VolumeUnit.class.getEnumConstants())) {
            String trueText = resources.getQuantityString(unit.getPlural(), value, value);
            if (trueText.equals(validateText)) {
                return unit;
            }
        }

        for (LengthUnit unit : Objects.requireNonNull(LengthUnit.class.getEnumConstants())) {
            String trueText = resources.getQuantityString(unit.getPlural(), value, value);
            if (trueText.equals(validateText)) {
                return unit;
            }
        }
        return null;
    }
}


