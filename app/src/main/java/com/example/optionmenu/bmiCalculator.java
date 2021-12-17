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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.text.DecimalFormat;

public class bmiCalculator extends AppCompatActivity {

    EditText heightInches, heightFeet, weight;
    TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);

        heightInches = findViewById(R.id.heightInchesTF);
        heightFeet = findViewById(R.id.heightFeetTF);
        weight = findViewById(R.id.weightTF);
        answer = findViewById(R.id.ouputTV);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String heightInchesStr = heightInches.getText().toString();
                String heightFeetStr = heightFeet.getText().toString();
                String weightStr = weight.getText().toString();

                if (heightInchesStr != null && !"".equals(heightInchesStr) && heightFeetStr != null && !"".equals(heightFeetStr)
                        && weightStr != null && !"".equals(weightStr)){
                    float heightInchesValue = Float.parseFloat(heightInchesStr) ;
                    float heightFeetValue = Float.parseFloat(heightFeetStr);
                    float weightValue = Float.parseFloat(weightStr);
                    float totalHeightInches = (heightFeetValue * 12) + heightInchesValue;
                    float bmi = (float) (weightValue / Math.pow(totalHeightInches, 2) * 703);
                    DecimalFormat df = new DecimalFormat("0.0");
                    displayBMI(Float.parseFloat(df.format(bmi)));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        heightInches.addTextChangedListener(textWatcher);
        heightFeet.addTextChangedListener(textWatcher);
        weight.addTextChangedListener(textWatcher);

    }

    private void displayBMI(float bmi){
        String bmiOutput = "";

        if(Float.compare(bmi, 15f) <= 0){
            bmiOutput = "Very severely underweight";
        } else if(Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 16f) <=0){
            bmiOutput = "Severely underweight";
        } else if(Float.compare(bmi, 16f) > 0 && Float.compare(bmi, 18.5f) <=0){
            bmiOutput = "Underweight";
        } else if(Float.compare(bmi, 18.5f) > 0 && Float.compare(bmi, 25f) <=0){
            bmiOutput = "Normal";
        } else if(Float.compare(bmi, 25f) > 0 && Float.compare(bmi, 30f) <=0){
            bmiOutput = "Overweight";
        } else if(Float.compare(bmi, 30f) > 0 && Float.compare(bmi, 35f) <=0){
            bmiOutput = "Obese Class I";
        } else if(Float.compare(bmi, 35f) > 0 && Float.compare(bmi, 40f) <=0) {
            bmiOutput = "Obese Class II";
        } else {
            bmiOutput = "Obese Class III";
        }

        bmiOutput = bmi + "\n" + bmiOutput;
        answer.setText(bmiOutput);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
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
    public void bmiCalculator(){
        Intent calc = new Intent(bmiCalculator.this, bmiCalculator.class);
        startActivity(calc);
    }
    public void speedConverter(){
        Intent convert = new Intent(bmiCalculator.this, speedConverter.class);
        startActivity(convert);
    }
}