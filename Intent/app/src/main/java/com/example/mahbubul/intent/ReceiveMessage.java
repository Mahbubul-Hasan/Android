package com.example.mahbubul.intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiveMessage extends AppCompatActivity {
    TextView receiveTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);

        receiveTextView = findViewById(R.id.receiveTextView);

        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("message");

        receiveTextView.setText(message);
    }
}
