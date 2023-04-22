package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.List;

public class Result extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();
        String a=intent.getStringExtra("gender");
        String b=intent.getStringExtra("grade");
        String c=intent.getStringExtra("diningPlace");
        String d=intent.getStringExtra("expenditure");
        ((TextView)findViewById(R.id.result_gender)).setText(a);
        ((TextView)findViewById(R.id.result_grade)).setText(b);
        ((TextView)findViewById(R.id.result_diningPlace)).setText(c);
        ((TextView)findViewById(R.id.result_expenditure)).setText(d);
    }
}

