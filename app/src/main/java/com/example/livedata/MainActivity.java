package com.example.livedata;


import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {


    ViewModels viewModels;
    Switch aSwitch;
    ConstraintLayout clayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aSwitch = findViewById(R.id.bgswitch);
        clayout = findViewById(R.id.layout);


        viewModels  = new ViewModelProvider(this).get(ViewModels.class);
        viewModels.dataState.observe(this, new Observer<Boolean>
                () {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aSwitch.isChecked()) {
                    clayout.setBackgroundColor(Color.parseColor("#FF000000"));
                }
                else {
                    clayout.setBackgroundColor(Color.parseColor("#FF03DAC5"));
                }
            }
        });

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (viewModels.dataState.getValue() == null) {
                    viewModels.dataState.setValue(true);
                }
                else{
                    viewModels.dataState.setValue(false);
                }
            }
        });






    }







}