package com.example.mahbubulhasan.implicitintentcallemail;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EmployeeDetailsActivity extends AppCompatActivity {
    private TextView phoneTextView, emailTextView;
    private ImageView callImageView, emailImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);

        phoneTextView  = findViewById(R.id.phoneTextView);
        emailTextView  = findViewById(R.id.emailTextView);
        callImageView  = findViewById(R.id.callImageView);
        emailImageView = findViewById(R.id.emailImageView);

        Intent intent = getIntent();
        final Employee employee = (Employee) intent.getSerializableExtra("employee");

        try{
            phoneTextView.setText(employee.getPhone());
            emailTextView.setText(employee.getEmail());
        }catch (NullPointerException e){
            Toast.makeText(this, "Something is wrong", Toast.LENGTH_SHORT).show();
        }

        callImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + employee.getPhone()));
                if (callIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(callIntent);
                }else {
                    Toast.makeText(EmployeeDetailsActivity.this, "No component found", Toast.LENGTH_SHORT).show();
                }
            }
        });

        emailImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("*/*");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{employee.getEmail()});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Test Mail");
//                emailIntent.putExtra(Intent.EXTRA_STREAM, attachment);
                if (emailIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(emailIntent);
                }
            }
        });
    }
}
