package com.example.project4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    RadioGroup rdg1,Class;
    RadioButton rbtn,c1,c2,c3,c4,c5;
    CheckBox food1,food2,food3,food4,food5;
    TextView tv;
    String s1,s2,food;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rdg1 = findViewById(R.id.rdg1);
        rbtn = findViewById(R.id.rbtn);
        Class = findViewById(R.id.Class);
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        c5=findViewById(R.id.c5);
        food1 = findViewById(R.id.food1);
        food2 = findViewById(R.id.food2);
        food3 = findViewById(R.id.food3);
        food4 = findViewById(R.id.food4);
        food5 = findViewById(R.id.food5);
        tv = findViewById(R.id.tv);
        food = new String();
        rdg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbtn) {
                    s1 = "你的性别是：男";
                } else {
                    s1 = "你的性别是：女";
                }
            }
        });
        Class.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.c1) {
                    s2 = "你的年级是大一";
                }
                if (checkedId == R.id.c2) {
                    s2 = "你的年级是大二";
                }
                if (checkedId == R.id.c3) {
                    s2 = "你的年级是大三";
                }
                if (checkedId == R.id.c4) {
                    s2 = "你的年级是大四";
                }
                if(checkedId==R.id.c5){
                    s2="你的年级是研究生";
                }
            }
        });
        food1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String motion = buttonView.getText().toString();
                if(isChecked)
                {
                    if(!food.contains(motion))
                    {
                        food = food + motion + ",";
                    }
                }
                else
                {
                    if(food.contains(motion))
                    {
                        food = food.replace(motion,"");
                    }
                }
            }
        });
        food2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String motion = buttonView.getText().toString();
                if(isChecked)
                {
                    if(!food.contains(motion))
                    {
                        food = food + motion + ",";
                    }
                }
                else
                {
                    if(food.contains(motion))
                    {
                        food = food.replace(motion,"");
                    }
                }
            }
        });
        food3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String motion = buttonView.getText().toString();
                if(isChecked)
                {
                    if(!food.contains(motion))
                    {
                        food = food + motion + ",";
                    }
                }
                else
                {
                    if(food.contains(motion))
                    {
                        food = food.replace(motion,"");
                    }
                }
            }
        });
        food4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String motion = buttonView.getText().toString();
                if(isChecked)
                {
                    if(!food.contains(motion))
                    {
                        food = food + motion + ",";
                    }
                }
                else
                {
                    if(food.contains(motion))
                    {
                        food = food.replace(motion,"");
                    }
                }
            }
        });
        food5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String motion = buttonView.getText().toString();
                if(isChecked)
                {
                    if(!food.contains(motion))
                    {
                        food = food + motion + ",";
                    }
                }
                else
                {
                    if(food.contains(motion))
                    {
                        food = food.replace(motion,"");
                    }
                }
            }
        });
    }

    public void OK(View v) {
        Intent Intent = new  Intent(this,show.class);
        String m;
        m = ((EditText)findViewById(R.id.moeny)).getText().toString();
        Intent.putExtra("xin",s1);
        Intent.putExtra("nian",s2);
        Intent.putExtra("shi",food);
        Intent.putExtra("qian",m);
        startActivity(Intent);
    }
}