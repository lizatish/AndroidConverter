package com.tishkovets.lab2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Validator {
    private static final List<String> validationMetersValues = Arrays.asList("метр", "метра", "метров");
    private static final List<String> validationInchesValues = Arrays.asList("дюйм", "дюйма", "дюймов");
    private static final List<String> validationFeetValues = Arrays.asList("фут", "фута", "футов");
    private static final List<String> validationYardsValues = Arrays.asList("ярд", "ярда", "ярдов");

    private static final List<String> validationKilogramsValues = Arrays.asList("килограмм", "килограмма", "килограммов");
    private static final List<String> validationPoundsValues = Arrays.asList("фунт", "фунта", "фунтов");
    private static final List<String> validationGroansValues = Arrays.asList("унция", "унции", "унций");
    private static final List<String> validationOunceValues = Arrays.asList("стона", "стоны", "стон");

    private static final List<String> validationLitersValues = Arrays.asList("литр", "литра", "литров");
    private static final List<String> validationGallonsValues = Arrays.asList("галлон", "галлона", "галлонов");
    private static final List<String> validationQuartsValues = Arrays.asList("кварт", "кварта", "квартов");
    private static final List<String> validationPintsValues = Arrays.asList("пинта", "пинты", "пинт");

    private final Map<Unit<?>, List<String>> units = new HashMap<>();


    public Validator() {
        units.put(LengthUnit.METER, validationMetersValues);
        units.put(LengthUnit.FOOT, validationFeetValues);
        units.put(LengthUnit.INCH, validationInchesValues);
        units.put(LengthUnit.YARD, validationYardsValues);

        units.put(MassUnit.KILOGRAM, validationKilogramsValues);
        units.put(MassUnit.POUND, validationPoundsValues);
        units.put(MassUnit.GROAN, validationGroansValues);
        units.put(MassUnit.OUNCE, validationOunceValues);

        units.put(VolumeUnit.LITER, validationLitersValues);
        units.put(VolumeUnit.GALLON, validationGallonsValues);
        units.put(VolumeUnit.PINT, validationPintsValues);
        units.put(VolumeUnit.QUART, validationQuartsValues);
    }

    public boolean isDouble(String value) {
        boolean result = false;
        if (value.matches("[-+]?\\d+")) {
            result = true;
        }
        return result;
    }

    public Unit<?> getUnitOrNull(String value) {
        Unit<?> result = null;
        for (Map.Entry<Unit<?>, List<String>> pair : units.entrySet()) {
            List<String> validationWords = pair.getValue();
            if (validationWords.contains(value)) {
                result = pair.getKey();
                break;
            }
        }
        return result;
    }
}


