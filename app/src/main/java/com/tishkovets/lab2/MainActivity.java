package com.tishkovets.lab2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.tishkovets.lab2.unit.UnitType;
import com.tishkovets.lab2.validation.TextGetter;
import com.tishkovets.lab2.validation.Validator;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private final UnitConverter unitConverter;
    private final Validator validator;

    EditText inputText;
    TextView outputText;

    Button button1;
    Button button2;
    Button button3;

    UnitType button1Type;
    UnitType button2Type;
    UnitType button3Type;

    UnitType currentType;
    double currentValue;

    public MainActivity() {
        this.unitConverter = new UnitConverter();
        this.validator = new Validator();
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
        inputText.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                validate();
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
    }

    private void validate() {
        String text = inputText.getText().toString();
        String[] parts = text.split(" ");

        if (parts.length == 2 && validator.isInt(parts[0])) {

            int value = Integer.parseInt(parts[0]);
            UnitType unitType = validator.getUnitOrNull(getResources(), text, value);

            if (unitType != null) {
                this.currentValue = value;
                this.currentType = unitType;
                this.setButtonsValues();
            } else {
                this.disableButtons();
                this.outputText.setHint(TextGetter.getErrorText());
            }
        } else {
            this.disableButtons();
            this.outputText.setHint(TextGetter.getErrorText());
        }
    }

    public void setButtonsValues() {
        List<UnitType> unitTypesWithoutCurrent = this.currentType.getEnumConstants();
        unitTypesWithoutCurrent.remove(this.currentType);
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
        this.currentValue = 0;
        this.currentType = null;

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
        double convertValue = unitConverter.convert(this.currentType, this.button1Type, this.currentValue);
        String result = validator.getStringOutput(getResources(), this.button1Type, convertValue);
        this.outputText.setText(TextGetter.getOutputText(inputText, result));
    }

    @SuppressLint("SetTextI18n")
    public void button2_OnClick(View view) {
        double convertValue = unitConverter.convert(this.currentType, this.button2Type, this.currentValue);
        String result = validator.getStringOutput(getResources(), this.button2Type, convertValue);
        this.outputText.setText(TextGetter.getOutputText(inputText, result));
    }

    @SuppressLint("SetTextI18n")
    public void button3_OnClick(View view) {
        double convertValue = unitConverter.convert(this.currentType, this.button3Type, this.currentValue);
        String result = validator.getStringOutput(getResources(), this.button3Type, convertValue);
        this.outputText.setText(TextGetter.getOutputText(inputText, result));
    }
}