package com.example.mahbubulhasan.clickeventlistener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {
    private Button button1, button2, button3, button4, button5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "button1 is clicked", Toast.LENGTH_SHORT).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "button2 is clicked", Toast.LENGTH_SHORT).show();
            }
        });

        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button5.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button btn = (Button) v;
        Toast.makeText(this, btn.getText(), Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onLongClick(View v) {
        Button btn = (Button) v;
        Toast.makeText(this, "Button5 pressed long", Toast.LENGTH_SHORT).show();
        return true;
    }
}
