package com.example.project4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class show extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Intent Intent = getIntent();
        String a = Intent.getStringExtra("xin");
        String b = Intent.getStringExtra("nian");
        String c = Intent.getStringExtra("shi");
        String d = Intent.getStringExtra("qian");
        ((TextView)findViewById(R.id.tv1)).setText(a);
        ((TextView)findViewById(R.id.tv2)).setText(b);
        ((TextView)findViewById(R.id.tv3)).setText("你日常在" + c +"用餐");
        ((TextView)findViewById(R.id.tv4)).setText("你一个月的平均费用为：" + d);
    }
}

