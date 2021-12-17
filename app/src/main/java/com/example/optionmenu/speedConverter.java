package com.example.optionmenu;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class speedConverter extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;
    String[] option = {"mph to kph", "kph to mph"};
    ArrayAdapter<String> arrayAdapter;
    EditText input;
    TextView unit, answerUnit, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed_converter);

        input = findViewById(R.id.inputTF);
        unit = findViewById(R.id.unitTV);
        answerUnit = findViewById(R.id.answerUnit);
        result = findViewById(R.id.resultTV);

        autoCompleteTextView = findViewById(R.id.items);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String userInput = input.getText().toString();
                if (userInput != null && !"".equals(userInput)) {
                    float userInputValue = Float.parseFloat(userInput);
                    float formula = (float) (userInputValue * 1.609344);
                    DecimalFormat df = new DecimalFormat("0.0");
                    result.setText(df.format(formula));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        input.addTextChangedListener(textWatcher);

        arrayAdapter = new ArrayAdapter<String>(this, R.layout.option_item, option);

        autoCompleteTextView.setAdapter(arrayAdapter);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String unit1 = "mph" , unit2 = "kph", answerUnit1="kph", answerUnit2="mph";
                switch (i) {
                    case 0:
                        unit.setText(unit1);
                        answerUnit.setText(answerUnit1);
                        break;
                    case 1:
                        input.setText("");
                        result.setText("");
                        unit.setText(unit2);
                        answerUnit.setText(answerUnit2);
                        break;
                }
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.om_calculator:
                Toast.makeText(this, "BMI Calculator", Toast.LENGTH_SHORT).show();
                bmiCalculator();
                return true;
            case R.id.om_converter:
                Toast.makeText(this, "Speed Converter", Toast.LENGTH_SHORT).show();
                speedConverter();
                return true;
            case R.id.om_exit:
                finishAffinity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void bmiCalculator() {
        Intent calc = new Intent(speedConverter.this, bmiCalculator.class);
        startActivity(calc);
    }

    public void speedConverter() {
        Intent convert = new Intent(speedConverter.this, speedConverter.class);
        startActivity(convert);
    }
}