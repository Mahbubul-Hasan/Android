package com.example.mahbubulhasan.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import static com.example.mahbubulhasan.menu.R.color.*;

public class MainActivity extends AppCompatActivity {
    private boolean isLoggedIn = false;
    private LinearLayout mainLinearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLinearLayout = findViewById(R.id.mainLinearLayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_maenu,menu );
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.homeItem:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                break;
            case R.id.settingsItem:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.loginItem:
                isLoggedIn = true;
                break;
            case R.id.logoutItem:
                isLoggedIn = false;
                break;
            case R.id.defaultThemeItem:
                if (item.isChecked()){
                    item.setChecked(true);
                }else {
                    item.setChecked(false);
                }
                mainLinearLayout.setBackgroundResource(colorDefault);
                break;
            case R.id.darkThemeItem:
                if (item.isChecked()){
                    item.setChecked(true);
                }else {
                    item.setChecked(false);
                }
                mainLinearLayout.setBackgroundResource(colorDark);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem login  = menu.findItem(R.id.loginItem);
        MenuItem logout = menu.findItem(R.id.logoutItem);
        if (isLoggedIn){
            login.setVisible(false);
            logout.setVisible(true);
        }else {
            login.setVisible(true);
            logout.setVisible(false);
        }
        return super.onPrepareOptionsMenu(menu);
    }
}
