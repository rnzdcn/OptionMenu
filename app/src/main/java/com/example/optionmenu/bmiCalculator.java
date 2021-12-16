package com.example.optionmenu;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class bmiCalculator extends AppCompatActivity {

    EditText heightInches, heightFeet, weight;
    TextView answer;
    Button calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);

        heightInches = findViewById(R.id.heightInchesTF);
        heightFeet = findViewById(R.id.heightFeetTF);
        weight = findViewById(R.id.weightTF);
        answer = findViewById(R.id.ouputTV);

        calculate = findViewById(R.id.calculateBtn);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBMI();
            }
        });

    }

    private void calculateBMI(){
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