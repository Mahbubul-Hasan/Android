package com.example.mahbubulhasan.edittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView headerText;
    private EditText inputText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        headerText = findViewById(R.id.headerText);
        inputText = findViewById(R.id.inputText);
    }

    public void changeText(View view) {
        switch (view.getId())
        {
            case R.id.changeText:
                String input = inputText.getText().toString();
                headerText.setText(input);
                break;
            case R.id.clearText:
                headerText.setText("");
                inputText.setText("");
                break;
        }

    }
}
