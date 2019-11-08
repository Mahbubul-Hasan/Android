package com.example.mahbubulhasan.loginbasic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String EMAIL    = "test@gmail.com";
    private final String PASSWORD = "12345";

    private EditText emailInput;
    private EditText passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailInput    = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
    }

    public void login(View view) {
        String email    = emailInput.getText().toString();
        String password = passwordInput.getText().toString();

        if (email.isEmpty())
        {
            emailInput.setError(getString(R.string.error_message));
        }
        else if (password.isEmpty())
        {
            passwordInput.setError(getString(R.string.error_message));
        }
        else
        {
            if (email.equals(EMAIL) && password.equals(PASSWORD))
            {
                Toast.makeText(this, "Welcome", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(this, "Email or Password is wrong", Toast.LENGTH_LONG).show();
            }
        }
    }
}
