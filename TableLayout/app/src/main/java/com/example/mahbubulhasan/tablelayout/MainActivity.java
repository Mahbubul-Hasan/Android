package com.example.mahbubulhasan.tablelayout;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> languages = new ArrayList<>();
    private RadioGroup genderRadioGroup;
    private String gender = "Male";
    private EditText nameEditText, ageEditText, phoneEditText, emailEditText;
    private Spinner citySpinner;
    private String city, dob;
    private Button dobButton;
    private Calendar calendar;
    private int year, month, dayOfMonth;
    private boolean isLoggedIn = false;
    private LinearLayout mainLinearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText  = findViewById(R.id.nameEditText);
        ageEditText   = findViewById(R.id.ageEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        emailEditText = findViewById(R.id.emailEditText);
        citySpinner   = findViewById(R.id.citySpinner);
        dobButton     = findViewById(R.id.dobButton);
        mainLinearLayout = findViewById(R.id.mainLinearLayout);
        calendar      = Calendar.getInstance();
        year          = calendar.get(Calendar.YEAR);
        month         = calendar.get(Calendar.MONTH);
        dayOfMonth    = calendar.get(Calendar.DAY_OF_MONTH);

        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        genderRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton genderButton = findViewById(checkedId);
                gender = genderButton.getText().toString();
                Toast.makeText(MainActivity.this, " "+gender, Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getCites());
        citySpinner.setAdapter(adapter);

        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                city =  getCites().get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        citySpinner.setSelection(getCites().indexOf("Jessore"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.maim_menu, menu);
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
                showLoginBox();
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
                mainLinearLayout.setBackgroundResource(R.color.colorDefault);
                break;
            case R.id.darkThemeItem:
                if (item.isChecked()){
                    item.setChecked(true);
                }else {
                    item.setChecked(false);
                }
                mainLinearLayout.setBackgroundResource(R.color.colorDark);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem login = menu.findItem(R.id.loginItem);
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

    public void selectedLanguage(View view) {
        CheckBox checkBox = (CheckBox) view;
        String selectedLanguage = checkBox.getText().toString();
        if (checkBox.isChecked()){
            languages.add(selectedLanguage);
        }else {
            languages.remove(selectedLanguage);
        }

        for (String printLanguage : languages){
            Log.e("test", "selectedLanguage: "+printLanguage );
        }
    }

    public void employeeRegistration(View view) {
        if (!isLoggedIn){
            showLoginBox();
        }else {
            empRegistration();
        }

    }

    private List<String> getCites(){
        List<String>cities = new ArrayList<>();
        cities.add("Dhaka");
        cities.add("Chittagong");
        cities.add("Khulna");
        cities.add("Barishal");
        cities.add("Rangpur");
        cities.add("Bogra");
        cities.add("Gaibandha");
        cities.add("Jessore");
        cities.add("Rajshahi");
        cities.add("Sylhet");
        cities.add("Mymansingh");

        return cities;
    }

    public void selectDate(View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Calendar calendarTemp = Calendar.getInstance();
                calendarTemp.set(year, month, dayOfMonth);
                dob = simpleDateFormat.format(calendarTemp.getTime());
                dobButton.setText(dob);
            }
        }, year, month, dayOfMonth);
        datePickerDialog.show();
    }

    private void showLoginBox(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View view = layoutInflater.inflate(R.layout.login, null);
        dialog.setTitle("Login");
        dialog.setIcon(R.mipmap.ic_launcher_round);
        dialog.setView(view);
        final EditText userNameEditText = view.findViewById(R.id.userNameEditText);
        final EditText passwordEditText = view.findViewById(R.id.passwordEditText);
        dialog.setPositiveButton("Login", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String userName = userNameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (userName.equals(EmployeeUtils.userName) && password.equals(EmployeeUtils.password)){
                    isLoggedIn = true;
                    Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                    empRegistration();
                }else {
                    Toast.makeText(MainActivity.this, "User Name or Password is invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dialog.setNegativeButton("Cancel", null);
        dialog.show();
    };

    private void empRegistration(){
        String name  = nameEditText.getText().toString();
        String age   = ageEditText.getText().toString();
        String phone = phoneEditText.getText().toString();
        String email = emailEditText.getText().toString();

        Employee employee = new Employee(name, age, phone, email, gender, city, languages, dob);
        Intent intent = new Intent(MainActivity.this, EmployeeDetailsActivity.class);
        intent.putExtra("employee", employee);
        startActivity(intent);
    }
}
