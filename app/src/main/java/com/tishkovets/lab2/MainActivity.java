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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private final UnitConverter unitConverter;
    private final Validator validator;
    EditText inputText;
    TextView outputText;

    Button button1;
    Button button2;
    Button button3;

    Unit button1Type;
    Unit button2Type;
    Unit button3Type;

    Unit currentType;
    double currentValue;

    public MainActivity() {
        this.unitConverter = new UnitConverter();
        this.validator = new Validator();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        this.disableButtons();

        inputText = findViewById(R.id.inputText);
        outputText = findViewById(R.id.outputText);

        inputText.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                outputText.setText(inputText.getText().toString());
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

        if (parts.length == 2 && validator.isDouble(parts[0])) {

            double value = Double.parseDouble(parts[0]);
            Unit type = validator.getUnitOrNull(parts[1]);

            if (type != null) {
                this.currentValue = value;
                this.currentType = type;

                List<Unit> targetList = this.currentType.getEnumConstants();
                targetList.remove(this.currentType);

                this.enableButtons(targetList.get(0), targetList.get(1), targetList.get(2));
            } else {
                this.disableButtons();
            }
        } else {
            this.disableButtons();
        }
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

    private void enableButtons(Unit button1Type, Unit button2Type, Unit button3Type) {
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
        double convertValue = unitConverter.convert(this.button1Type, this.currentType, this.currentValue);
        this.outputText.setText(Double.toString(convertValue));

    }

    @SuppressLint("SetTextI18n")
    public void button2_OnClick(View view) {
        double convertValue = unitConverter.convert(this.button2Type, this.currentType, this.currentValue);
        this.outputText.setText(Double.toString(convertValue));

    }

    @SuppressLint("SetTextI18n")
    public void button3_OnClick(View view) {
        double convertValue = unitConverter.convert(this.button3Type, this.currentType, this.currentValue);
        this.outputText.setText(Double.toString(convertValue));
    }
}