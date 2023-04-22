package com.example.test_project1;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn;//开始游戏 逻辑：点击button之后，地鼠出现在中间位置，同时可以被点击，然后开始倒计时，按钮将消失
    private TextView scoreTv;  //当确认地鼠被点击到时，分数会自增
    private TextView secondTv;  //  可以使用handler写一个计时器的方法，判断倒数的事件是否为0.
    private ImageView mouseIv;  //点击事件：让原来位置的老鼠消失，随机生成新的位置，让老鼠出现在新的位置上，分数加1
    int height;   //屏幕的高度
    int width;  //屏幕的宽度
    int score = 0; // 定义一个表示当前分数的变量
    int totalTime = 10; //定义一个表示每一次游戏时间的变量
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==100) {
                int time = msg.arg1;
                if (time>0) {
//                  时间还没有结束，对于TextView进行修改
                    secondTv.setText(time+"");
                }else{
//                    时间到了    1.让按钮展示出来    2.老鼠不能在点击了
                    btn.setVisibility(View.VISIBLE);
                    secondTv.setText(""+10);
                    mouseIv.setClickable(false);
                    Toast.makeText(MainActivity.this,"游戏结束",Toast.LENGTH_LONG).show();
                }
            }else if (msg.what==200) {    //
                int mX = msg.arg1;
                int mY = msg.arg2;
                Log.i("tag111", "handleMessage:地鼠的位置x: "+mX+"，y的位置:"+mY);
                scoreTv.setText(score+"分");
                mouseIv.setVisibility(View.VISIBLE);
                mouseIv.setX(mX);
                mouseIv.setY(mY);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.hw_btn_start);
        scoreTv = (TextView) findViewById(R.id.hw_tv_score);
        secondTv = (TextView) findViewById(R.id.hw_tv_second);
        mouseIv = (ImageView) findViewById(R.id.hw_mouse_iv);
        /**
         * 获取屏幕的宽度和高度
         * */
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        this.height = metrics.heightPixels;
        this.width = metrics.widthPixels;
        Log.i("tag111", "onCreate: 屏幕的height==="+ this.height +",width=="+ this.width);
        //设置点击事件
        btn.setOnClickListener(this);
        mouseIv.setOnClickListener(this);
        mouseIv.setClickable(false);   //设置地鼠不能被点击
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.hw_btn_start:   //开始游戏的点击
//              设置地鼠可以被点击
                mouseIv.setClickable(true);
//                设置地鼠最初的坐标
                mouseIv.setX(width / 2);
                mouseIv.setY(height / 2);
//                隐藏button按钮
                btn.setVisibility(View.INVISIBLE);
//              开始倒计时
                startCountDown();
                break;
            case R.id.hw_mouse_iv:   //地鼠的点击
                mouseIv.setVisibility(View.INVISIBLE);
                score++;
                Message msg = new Message();
                msg.what = 200;
//                随机数   = （int）(最小值+Math.random*(最大值-最小值));
                msg.arg1 = (int)(Math.random()*(width-400)+200);    //老鼠随机生成的x轴的位置
                msg.arg2 = (int)(Math.random()*(height-400)+200);
//                发送一条消息通知老鼠出现
                handler.sendMessageDelayed(msg,200);
                break;
        }
    }
    /**
     * @des 开始倒计时的方法
     */
    public void startCountDown() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = totalTime-1; i >=0 ; i--) {
                    try {
                        Thread.sleep(1000);
//                        向子线程发送一条消息
                        Message msg = new Message();
                        msg.what = 100;
                        msg.arg1 = i;
                        handler.sendMessage(msg);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}