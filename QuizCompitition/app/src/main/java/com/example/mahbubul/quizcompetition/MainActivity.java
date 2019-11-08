package com.example.mahbubul.quizcompetition;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText userName, password;
    Button signIn, signUp,button;

    RadioGroup radioGroup;
    RadioButton radioButton1, radioButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.userNameET);
        password = findViewById(R.id.passwordET);
        signIn = findViewById(R.id.signInBT);
        signUp = findViewById(R.id.signUpBT);

        radioGroup = findViewById(R.id.radiogroupid);
        radioButton1 = findViewById(R.id.studentid);
        radioButton2 = findViewById(R.id.adminid);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn_onClick(v);
            }

        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp_onClick(v);
            }
        });


    }

    public void signIn_onClick(View v) {
        UsersDB usersDB = new UsersDB(getApplicationContext());
        String name = userName.getText().toString();
        String pass = password.getText().toString();

        Users users = usersDB.signIn(name, pass);
        if (users == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
            builder.setTitle("Error");
            builder.setMessage("Invalid Account");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.show();
        } else {
//            Intent intent = new Intent(MainActivity.this, StartQuizActivity.class);
//            intent.putExtra("user", users);
//            startActivity(intent);
//
            int selectedid = radioGroup.getCheckedRadioButtonId();
            if (selectedid == R.id.studentid) {

                Intent intent = new Intent(MainActivity.this, StartQuizActivity.class);
//                intent.putExtra("user", users);
                startActivity(intent);

           }
           else if (selectedid==R.id.adminid){
               Intent intent = new Intent(MainActivity.this,AdminActivity.class);
                intent.putExtra("user", users);
                startActivity(intent);

            }
        }
    }

    public void signUp_onClick(View v) {
        Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
        startActivity(intent);
    }
}
