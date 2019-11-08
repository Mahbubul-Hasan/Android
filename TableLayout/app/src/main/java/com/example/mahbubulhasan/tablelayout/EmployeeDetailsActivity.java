package com.example.mahbubulhasan.tablelayout;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EmployeeDetailsActivity extends AppCompatActivity {
    private TextView nameTextView, ageTextView, phoneTextView, emailTextView, genderTextView, languagesTextView, cityTextView, dobTextView;
    private ImageView callImageView, emailImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);

        nameTextView      = findViewById(R.id.nameTextView);
        ageTextView       = findViewById(R.id.ageTextView);
        phoneTextView     = findViewById(R.id.phoneTextView);
        emailTextView     = findViewById(R.id.emailTextView);
        genderTextView    = findViewById(R.id.genderTextView);
        languagesTextView = findViewById(R.id.languagesTextView);





        cityTextView      = findViewById(R.id.cityTextView);
        callImageView     = findViewById(R.id.callImageView);
        emailImageView    = findViewById(R.id.emailImageView);
        dobTextView       = findViewById(R.id.dobTextView);

        Intent intent = getIntent();
        final Employee employee = (Employee) intent.getSerializableExtra("employee");
        try{
            nameTextView.setText(employee.getName());
            ageTextView.setText(employee.getAge());
            phoneTextView.setText(employee.getPhone());
            emailTextView.setText(employee.getEmail());
            genderTextView.setText(employee.getGender());
            cityTextView.setText(employee.getCity());
            dobTextView.setText(employee.getDob());

            String languages = TextUtils.join(", ", employee.getLanguages());
            languagesTextView.setText(languages);
        }catch (NullPointerException e){
            Toast.makeText(this, "Invalid Object", Toast.LENGTH_SHORT).show();
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
