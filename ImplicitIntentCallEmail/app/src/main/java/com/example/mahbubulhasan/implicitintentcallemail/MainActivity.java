package com.example.mahbubulhasan.implicitintentcallemail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText phoneEditText, emailEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneEditText = findViewById(R.id.phoneEditText);
        emailEditText = findViewById(R.id.emailEditText);
    }

    public void registerInfo(View view) {
        String phone = phoneEditText.getText().toString();
        String email = emailEditText.getText().toString();

        Employee employee = new Employee(phone, email);

        Intent intent = new Intent(MainActivity.this, EmployeeDetailsActivity.class);
        intent.putExtra("employee", employee);
        startActivity(intent);
    }
}
