package com.example.morewidgetsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox box1,box2;
    Button btn;
    RadioGroup radioGroup;
    Spinner spinner;
    Button timePickerButton;
    Button datePickerButtton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //checkbox
        box1 = findViewById(R.id.checkBox1);
        box2 = findViewById(R.id.checkBox2);
        btn = findViewById(R.id.button);
        timePickerButton = findViewById(R.id.button2);
        datePickerButtton = findViewById(R.id.button3);
        datePickerButtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = new DatePickerFragment();
                dialogFragment.show(getSupportFragmentManager(),"Pick A Date");
            }
        });
        timePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Display the time picker
                DialogFragment timePickerFrag = new timePickerFragment();
                timePickerFrag.show(getSupportFragmentManager(),"Pick TIme Now");
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(box1.isChecked()){
                    Toast.makeText(MainActivity.this, "cheese topping is added", Toast.LENGTH_SHORT).show();
                }else {

                }
                if(box2.isChecked()) {
                    Toast.makeText(MainActivity.this, "tomato topping is added", Toast.LENGTH_SHORT).show();
                }else {

                }
            }
        });
        //SPINNER
        //step-3: spinner
        spinner = findViewById(R.id.spinner);
       // Step-1: Dataset
        String [] courses = {"C++","Java","kotlin","Data structures"};
        //step-2: Adapter
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item,courses);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(ad);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "selected :" +courses[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //RADIOGROUP
        radioGroup = findViewById(R.id.radioGroup2);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                Toast.makeText(MainActivity.this, "selected: "+radioButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}