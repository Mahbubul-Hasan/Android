package com.example.mahbubulhasan.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner citySpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        citySpinner = findViewById(R.id.citySpinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner, getCities());
        citySpinner.setAdapter(adapter);

        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String city = getCities().get(position);
                Toast.makeText(MainActivity.this, city, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        citySpinner.setSelection(getCities().indexOf("Jessore"));
    }

    private List<String> getCities(){
        List<String>cities = new ArrayList<>();
        cities.add("Dhaka");
        cities.add("Chittagong");
        cities.add("Khulna");
        cities.add("Barishal");
        cities.add("Rangpur");
        cities.add("Bogra");
        cities.add("Gaibandha");
        cities.add("Jessore");
        cities.add("Rajshahi");
        cities.add("Sylhet");
        cities.add("Mymansingh");

        return cities;
    }
}
