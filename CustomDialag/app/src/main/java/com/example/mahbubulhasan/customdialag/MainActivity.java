package com.example.mahbubulhasan.customdialag;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectLanguage(View view) {
        final String cause[] = getResources().getStringArray(R.array.cause);
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Why Your Disable Your Account");
        dialog.setIcon(R.mipmap.ic_launcher_round);
        dialog.setItems(cause, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, cause[which], Toast.LENGTH_SHORT).show();
            }
        });
//        dialog.setMessage("Messages");
        dialog.setPositiveButton("Click", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }
}
