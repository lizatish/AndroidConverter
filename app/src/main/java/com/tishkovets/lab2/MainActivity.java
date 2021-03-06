package com.tishkovets.lab2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.tishkovets.lab2.unit.UnitType;
import com.tishkovets.lab2.validation.TextGetter;
import com.tishkovets.lab2.validation.Validator;

import java.util.List;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    private final UnitConverter unitConverter;
    private Unit currentUnit;

    EditText inputText;
    TextView outputText;

    Button button1;
    Button button2;
    Button button3;

    UnitType button1Type;
    UnitType button2Type;
    UnitType button3Type;

    public MainActivity() {
        this.unitConverter = UnitConverter.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.button1 = findViewById(R.id.button1);
        this.button2 = findViewById(R.id.button2);
        this.button3 = findViewById(R.id.button3);
        this.disableButtons();

        this.outputText = findViewById(R.id.outputText);
        this.outputText.setHint(TextGetter.getStartText());

        inputText = findViewById(R.id.inputText);
        inputText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {

                    validate();
                    return true;
                }
                return false;
            }
        });
    }

    private void validate() {
        String text = inputText.getText().toString().toLowerCase(Locale.ROOT);
        String[] parts = text.split(" ");

        if (parts.length == 2 && Validator.isInt(parts[0])) {

            int value = Integer.parseInt(parts[0]);
            Unit unit = Unit.fromString(getResources(), text, value);

            if (unit != null) {
                this.currentUnit = unit;
                this.setButtonsValues();
                this.outputText.setHint("");
            } else {
                this.disableButtons();
                this.outputText.setText("");
                this.outputText.setHint(TextGetter.getErrorText());
            }
        } else {
            this.disableButtons();
            this.outputText.setText("");
            this.outputText.setHint(TextGetter.getErrorText());
        }
    }

    public void setButtonsValues() {
        List<UnitType> unitTypesWithoutCurrent = this.currentUnit.getUnitType().getEnumConstants();
        unitTypesWithoutCurrent.remove(this.currentUnit.getUnitType());
        this.enableButtons(unitTypesWithoutCurrent.get(0), unitTypesWithoutCurrent.get(1),
                unitTypesWithoutCurrent.get(2));
    }

    private void disableButtons() {
        this.button1.setEnabled(false);
        this.button2.setEnabled(false);
        this.button3.setEnabled(false);

        this.button1Type = null;
        this.button2Type = null;
        this.button3Type = null;

        this.currentUnit = null;

        this.button1.setText("...");
        this.button2.setText("...");
        this.button3.setText("...");
    }

    private void enableButtons(UnitType button1Type, UnitType button2Type, UnitType button3Type) {
        this.button1.setEnabled(true);
        this.button2.setEnabled(true);
        this.button3.setEnabled(true);

        this.button1Type = button1Type;
        this.button2Type = button2Type;
        this.button3Type = button3Type;

        this.button1.setText(button1Type.toString());
        this.button2.setText(button2Type.toString());
        this.button3.setText(button3Type.toString());
    }

    @SuppressLint("SetTextI18n")
    public void button1_OnClick(View view) {
        Unit outputUnit = unitConverter.convert(this.currentUnit, this.button1Type);
        if (outputUnit != null) {
            String result = outputUnit.getStringOutput(getResources());
            this.outputText.setText(TextGetter.getOutputText(inputText, result));
        } else {
            this.outputText.setHint(TextGetter.getErrorText());
        }
    }

    @SuppressLint("SetTextI18n")
    public void button2_OnClick(View view) {
        Unit outputUnit = unitConverter.convert(this.currentUnit, this.button2Type);
        if (outputUnit != null) {
            String result = outputUnit.getStringOutput(getResources());
            this.outputText.setText(TextGetter.getOutputText(inputText, result));
        } else {
            this.outputText.setHint(TextGetter.getErrorText());
        }
    }

    @SuppressLint("SetTextI18n")
    public void button3_OnClick(View view) {
        Unit outputUnit = unitConverter.convert(this.currentUnit, this.button3Type);
        if (outputUnit != null) {
            String result = outputUnit.getStringOutput(getResources());
            this.outputText.setText(TextGetter.getOutputText(inputText, result));
        } else {
            this.outputText.setHint(TextGetter.getErrorText());
        }
    }
}