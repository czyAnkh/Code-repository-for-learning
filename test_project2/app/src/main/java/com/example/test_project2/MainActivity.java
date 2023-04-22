package com.example.test_project2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private int score = 0;
    private int time = 30;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView mouse = (ImageView)findViewById(R.id.mouse);
        final TextView scoreTextView = (TextView)findViewById(R.id.scoreTextView);
        final TextView timeTextView = (TextView)findViewById(R.id.timeTextView);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Random random = new Random();
                        int position = random.nextInt(9);
                        int x = 0, y = 0;
                        switch(position) {
                            case 0:
                                x = 100;
                                y = 100;
                                break;
                            case 1:
                                x = 300;
                                y = 100;
                                break;
                            case 2:
                                x = 500;
                                y = 100;
                                break;
                            case 3:
                                x = 100;
                                y = 300;
                                break;
                            case 4:
                                x = 300;
                                y = 300;
                                break;
                            case 5:
                                x = 500;
                                y = 300;
                                break;
                            case 6:
                                x = 100;
                                y = 500;
                                break;
                            case 7:
                                x = 300;
                                y = 500;
                                break;
                            case 8:
                                x = 500;
                                y = 500;
                                break;
                        }
                        mouse.setX(x);
                        mouse.setY(y);
                    }
                });
            }
        }, 0, 2000);

        mouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score++;
                scoreTextView.setText("Score: " + score);
                mouse.setVisibility(View.INVISIBLE);
            }
        });

        Timer timer2 = new Timer();
        timer2.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        time--;
                        timeTextView.setText("Time: " + time + "s");
                        if(time == 0) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("Game结束");
                            builder.setMessage("Your score is " + score);
                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            });
                            builder.show();
                        }
                    }
                });
            }
        }, 0, 1000);
    }
}
