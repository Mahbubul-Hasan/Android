package com.example.mahbubulhasan.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private List<String>language = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectLanguage(View view)
    {
        CheckBox checkBox = (CheckBox) view;
        String selectedLanguage = checkBox.getText().toString();
        if (checkBox.isChecked()){
            language.add(selectedLanguage);
        }else{
            language.remove(selectedLanguage);
        }

        for (String print : language){
            Log.e("test", "selectLanguage: "+print );
        }
    }
}
