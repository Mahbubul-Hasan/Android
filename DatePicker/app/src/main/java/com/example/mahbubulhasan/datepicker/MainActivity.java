package com.example.mahbubulhasan.datepicker;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Button dobButton;
    private Calendar calendar;
    private int year, month, dayOfMonth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dobButton = findViewById(R.id.dobButton);
        calendar = Calendar.getInstance(Locale.getDefault());
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
    }

    public void selectDate(View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                Toast.makeText(MainActivity.this, dayOfMonth+"/"+(month+1)+"/"+year, Toast.LENGTH_SHORT).show();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

                Calendar calendarTemp = Calendar.getInstance();
                calendarTemp.set(year, month, dayOfMonth );
                String date = simpleDateFormat.format(calendarTemp.getTime());
                dobButton.setText(date);
            }
        }, year, month, dayOfMonth);
        datePickerDialog.show();
    }
}
