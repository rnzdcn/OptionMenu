package com.example.optionmenu;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class speedConverter extends AppCompatActivity {
    int position;
    AutoCompleteTextView autoCompleteTextView;
    String []option = {"mph to kph" , "kph to mph"};
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed_converter);

        autoCompleteTextView = findViewById(R.id.items);


        arrayAdapter = new ArrayAdapter<String>(this, R.layout.option_item, option);
//        autoCompleteTextView.setText(arrayAdapter.getItem(0).toString(), false);

        autoCompleteTextView.setAdapter(arrayAdapter);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (position)
                {
                    case 0: // first one of the list
                       Intent intent = new Intent(speedConverter.this, bmiCalculator.class);
                        startActivity(intent);
                        break;
                    case 1: // second one of the list.
                        Intent c = new Intent(speedConverter.this, MainActivity.class);
                        startActivity(c);
                        break;
                    // and so on...
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
        Intent calc = new Intent(speedConverter.this, bmiCalculator.class);
        startActivity(calc);
    }

    public void speedConverter(){
        Intent convert = new Intent(speedConverter.this, speedConverter.class);
        startActivity(convert);
    }
}