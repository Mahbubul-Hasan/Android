package com.example.mahbubulhasan.helloword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView sampleText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sampleText = findViewById(R.id.text_sample);
    }

    public void ChangeSampleText(View view) {
        sampleText.setText("Mahbubul Hasan");
        Toast.makeText(this, ""+sampleText.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}
