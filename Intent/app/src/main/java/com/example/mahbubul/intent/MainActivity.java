package com.example.mahbubul.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText messageEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageEditText = findViewById(R.id.messageEditText);
    }

    public void sendMessage(View view) {
        String message = messageEditText.getText().toString();

        startActivity(new Intent(MainActivity.this, ReceiveMessage.class).putExtra("message", message));
    }
}
