package com.example.optionmenu;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        Intent calc = new Intent(MainActivity.this, bmiCalculator.class);
        startActivity(calc);
    }

    public void speedConverter(){
        Intent convert = new Intent(MainActivity.this, speedConverter.class);
        startActivity(convert);
    }


}