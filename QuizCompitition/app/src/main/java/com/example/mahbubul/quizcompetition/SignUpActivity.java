package com.example.mahbubul.quizcompetition;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {
    EditText userName, fullName, email, password;
    Button signUp, cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        userName = findViewById(R.id.userNameET);
        fullName = findViewById(R.id.fullNameET);
        email = findViewById(R.id.emailET);
        password = findViewById(R.id.passwordET);
        signUp = findViewById(R.id.signUpBT);
        cancel = findViewById(R.id.cancelBT);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp_onClick(v);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void signUp_onClick(View v) {
        try{
            UsersDB usersDB = new UsersDB(getApplicationContext());
            Users users = new Users();

            users.setUserName(userName.getText().toString());
            users.setFullName(fullName.getText().toString());
            users.setEmail(email.getText().toString());
            users.setPassword(password.getText().toString());

            Users temp = usersDB.checkUserName(userName.getText().toString());
            if (temp == null){
                if (usersDB.create(users)){
                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                    startActivity(intent);
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                    builder.setTitle("Error");
                    builder.setMessage("Can't create account");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    builder.show();
                }
            }else{
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Error");
                builder.setMessage("UserName Exists");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            }

//            if (usersDB.create(users)){
//                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
//                startActivity(intent);
//            }else {
//                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
//                builder.setTitle("Error");
//                builder.setMessage("UserName exists");
//                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.cancel();
//                    }
//                });
//                builder.show();
//            }
        }catch (Exception e){
            AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
            builder.setTitle("Error");
            builder.setMessage(e.getMessage());
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.show();
        }
    }
}
