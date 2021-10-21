package com.tishkovets.lab2;

public class UnitConverter {
    private static UnitConverter instance;

    public UnitConverter() {
    }

    private double toKilograms(final MassUnit unitType, double value) {
        double result = value;
        switch (unitType) {
            case GROAN:
                result /= MassUnit.GROAN.value;
                break;
            case POUND:
                result /= MassUnit.POUND.value;
                break;
            case OUNCE:
                result /= MassUnit.OUNCE.value;
                break;
        }
        return result;
    }

    public double convertMass(MassUnit inputType, MassUnit outputType, double value) {
        double kilogramValue = toKilograms(inputType, value);
        return value * outputType.value;
    }

    private double toLiters(final VolumeUnit unitType, double value) {
        double result = value;
        switch (unitType) {
            case QUART:
                result /= VolumeUnit.QUART.value;
                break;
            case PINT:
                result /= VolumeUnit.PINT.value;
                break;
            case GALLON:
                result /= VolumeUnit.GALLON.value;
                break;
        }
        return result;
    }

    public double convertVolume(VolumeUnit inputType, VolumeUnit outputType, double value) {
        double literValue = toLiters(inputType, value);
        return value * outputType.value;
    }

    private double toMeters(final LengthUnit unitType, double value) {
        double result = value;
        switch (unitType) {
            case INCH:
                result /= LengthUnit.INCH.value;
                break;
            case FOOT:
                result /= LengthUnit.FOOT.value;
                break;
            case YARD:
                result /= LengthUnit.YARD.value;
                break;
        }
        return result;
    }

    public double convertLength(LengthUnit inputType, LengthUnit outputType, double value) {
        double meterValue = toMeters(inputType, value);
        return value * outputType.value;
    }
}