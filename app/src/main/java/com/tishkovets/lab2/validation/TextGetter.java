package com.tishkovets.lab2.validation;

import android.widget.EditText;

import java.util.Locale;

public class TextGetter {

    public static String getStartText() {
        return "Данный конвертер позволяет работать " +
                "только со следующими единицами измерения:\n" +
                "Длина: метр, дюйм, фут, ярд\n" +
                "Масса: киллограмм, фут, унция, стона\n" +
                "Объем: литр, галлон, кварта, пинта";
    }

    public static String getErrorText() {
        return "ОШИБКА!\n\n" + TextGetter.getStartText();
    }

    public static String getOutputText(EditText inputVStr, String outputStr) {
        return inputVStr.getText().toString().toLowerCase(Locale.ROOT) + " это:\n" + outputStr;
    }

    public static String getDouble(double val) {
        return String.format("%1$,.4f", val);
    }
}