package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;





import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.*;
import java.util.ArrayList;
import java.util.*;

class InfixInToDuffix {
    //使用集合定义好符号的运算优先级别
    private static final Map<Character,Integer>basic =new HashMap<Character, Integer>();
    static {
        basic.put('-',1);
        basic.put('+', 1);
        basic.put('*', 3);
        basic.put('/', 3);
        basic.put('(', 0);
        basic.put('%',2);
    }


    //将中缀表达式转换为后缀表达式
    public String toSuffix(StringBuilder infix){
        List<String> queue = new ArrayList<String>();
        List<Character> stack = new ArrayList<Character>();

        char[] charArr = infix.substring(0,infix.length()).trim().toCharArray();
        String standard = "*/+-()%";
        char ch = '&';
        int len = 0;
        for (int i = 0; i < charArr.length; i++) {
            ch = charArr[i];
            if(Character.isDigit(ch)) {
                len++;
            }else if(ch == '.'){
                len++;
            }else if(standard.indexOf(ch) != -1) {
                if(len > 0) {
                    queue.add(String.valueOf(Arrays.copyOfRange(charArr, i - len, i)));
                    len = 0;
                }
                if(ch == '(') {
                    stack.add(ch);
                    continue;
                }
                if (!stack.isEmpty()) {
                    int size = stack.size() - 1;
                    boolean flag = false;
                    while (size >= 0 && ch == ')' && stack.get(size) != '(') {
                        queue.add(String.valueOf(stack.remove(size)));
                        size--;
                        flag = true;
                    }
                    if(ch==')'&&stack.get(size) == '('){
                        flag = true;
                    }
                    while (size >= 0 && !flag && basic.get(stack.get(size)) >= basic.get(ch)) {
                        queue.add(String.valueOf(stack.remove(size)));
                        size--;
                    }
                }
                if(ch != ')') {
                    stack.add(ch);
                } else {
                    stack.remove(stack.size() - 1);
                }
            }
            if(i == charArr.length - 1) {
                if(len > 0) {
                    queue.add(String.valueOf(Arrays.copyOfRange(charArr, i - len+1, i+1)));
                }
                int size = stack.size() - 1;
                while (size >= 0) {
                    queue.add(String.valueOf(stack.remove(size)));
                    size--;
                }
            }

        }
        String a = queue.toString();
        return a.substring(1,a.length()-1);
    }


    public String dealEquation(String equation){

        String [] arr = equation.split(", ");
        List<String> list = new ArrayList<String>();


        for (int i = 0; i < arr.length; i++) {
            int size = list.size();
            switch (arr[i]) {
                case "+": double a = Double.parseDouble(list.remove(size-2))+ Double.parseDouble(list.remove(size-2)); list.add(String.valueOf(a));     break;
                case "-": double b = Double.parseDouble(list.remove(size-2))- Double.parseDouble(list.remove(size-2)); list.add(String.valueOf(b));     break;
                case "*": double c = Double.parseDouble(list.remove(size-2))* Double.parseDouble(list.remove(size-2)); list.add(String.valueOf(c));     break;
                case "/": double d = Double.parseDouble(list.remove(size-2))/ Double.parseDouble(list.remove(size-2)); list.add(String.valueOf(d));       break;
                case "%": double e = Double.parseDouble(list.remove(size-2)) % Double.parseDouble(list.remove(size-2)); list.add(String.valueOf(e));     break;
                default: list.add(arr[i]);     break;                                    //如果是数字  直接放进list中
            }
        }
        return list.size() == 1 ? list.get(0) : "Fail" ;
    }
}


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button n0,n1,n2,n3,n4,n5,n6,n7,n8,n9;
    Button clear, divide, delete, add, sub, equal, mul, point,percent;
    private EditText input;

    private StringBuilder fomula = new StringBuilder();

    private void initP() {
        n0 = (Button) findViewById(R.id.n0);
        n1 = (Button) findViewById(R.id.n1);
        n2 = (Button) findViewById(R.id.n2);
        n3 = (Button) findViewById(R.id.n3);
        n4 = (Button) findViewById(R.id.n4);
        n5 = (Button) findViewById(R.id.n5);
        n6 = (Button) findViewById(R.id.n6);
        n7 = (Button) findViewById(R.id.n7);
        n8 = (Button) findViewById(R.id.n8);
        n9 = (Button) findViewById(R.id.n9);
        clear = (Button) findViewById(R.id.clear);
        divide = (Button) findViewById(R.id.divide);
        delete = (Button) findViewById(R.id.delete);
        add = (Button) findViewById(R.id.add);
        sub = (Button) findViewById(R.id.sub);
        equal = (Button) findViewById(R.id.equal);
        point = (Button) findViewById(R.id.point);
        percent =(Button)findViewById(R.id.percent);
        mul=(Button)findViewById(R.id.mul);

        input = (EditText) findViewById(R.id.input);

        input.setKeyListener(null);


        n0.setOnClickListener(this);
        n1.setOnClickListener(this);
        n2.setOnClickListener(this);
        n3.setOnClickListener(this);
        n4.setOnClickListener(this);
        n5.setOnClickListener(this);
        n6.setOnClickListener(this);
        n7.setOnClickListener(this);
        n8.setOnClickListener(this);
        n9.setOnClickListener(this);
        add.setOnClickListener(this);
        clear.setOnClickListener(this);
        divide.setOnClickListener(this);
        delete.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        point.setOnClickListener(this);
        equal.setOnClickListener(this);
        percent.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initP();
    }

    @Override
    public void onClick(View v) {
        int latest = 0;
        if (fomula.length() != 0) {
            latest = fomula.codePointAt(fomula.length() - 1);
        }
        else
            latest = '.';

        switch (v.getId()) {
            case R.id.n0:
                fomula = fomula.append("0");
                input.setText(fomula);
                break;
            case R.id.n1:
                fomula = fomula.append("1");
                input.setText(fomula);
                break;
            case R.id.n2:
                fomula = fomula.append("2");
                input.setText(fomula);
                break;
            case R.id.n3:
                fomula = fomula.append("3");
                input.setText(fomula);
                break;
            case R.id.n4:
                fomula = fomula.append("4");
                input.setText(fomula);
                break;
            case R.id.n5:
                fomula = fomula.append("5");
                input.setText(fomula);
                break;
            case R.id.n6:
                fomula = fomula.append("6");
                input.setText(fomula);
                break;
            case R.id.n7:
                fomula = fomula.append("7");
                input.setText(fomula);
                break;
            case R.id.n8:
                fomula = fomula.append("8");
                input.setText(fomula);
                break;
            case R.id.n9:
                fomula = fomula.append("9");
                input.setText(fomula);
                break;
            case R.id.sub:
                if (latest >= '0' && latest <= '9')
                    fomula = fomula.append("-");
                else {
                    if(latest != '.')
                        fomula.delete(fomula.length()-1, fomula.length());
                    fomula = fomula.append("-");
                }
                input.setText(fomula);
                break;
            case R.id.add:
                if (latest >= '0' && latest <= '9')
                    fomula = fomula.append("+");
                else {
                    if(latest != '.')
                        fomula.delete(fomula.length()-1, fomula.length());
                    fomula = fomula.append("+");
                }
                input.setText(fomula);
                break;
            case R.id.mul:
                if (latest >= '0' && latest <= '9')
                    fomula = fomula.append("*");
                else {
                    if(latest != '.')
                        fomula = fomula.delete(fomula.length()-1,fomula.length());
                    fomula = fomula.append("*");
                }
                input.setText(fomula);
                break;
            case R.id.divide:
                if (latest >= '0' && latest <= '9')
                    fomula = fomula.append("/");
                else {
                    if(latest != '.')
                        fomula.delete(fomula.length()-1, fomula.length());
                    fomula = fomula.append("/");
                }
                input.setText(fomula);
                break;
            case R.id.delete:
                if (fomula.length() > 0)
                    fomula = fomula.delete(fomula.length() - 1, fomula.length());
                input.setText(fomula);
                break;
            case R.id.clear:
                fomula = fomula.delete(0, fomula.length());
                input.setText(fomula);
                break;
            case R.id.equal:
                String ans="0";
                if(fomula.length()>1){
                    InfixInToDuffix inf = new InfixInToDuffix();
                    try{
                        String a = inf.toSuffix(fomula);
                        System.out.println("out:");
                        System.out.println(a);
                        ans = inf.dealEquation(a);
                        fomula = fomula.delete(0,fomula.length());
                        fomula = fomula.append(ans);
                    }catch (Exception ex){
                        ans = "error";
                        fomula = fomula.delete(0,fomula.length());
                    }
                }
                input.setText(ans);
                break;
            case R.id.point:
                fomula = fomula.append(".");
                input.setText(fomula);
                break;
            case R.id.percent:
                if(latest >= '0' && latest <= '9'){
                    fomula.append("%");
                }
                else
                {
                    if(latest != '.')
                        fomula.delete(fomula.length()-1,fomula.length());
                    fomula.append("%");
                }
                input.setText(fomula);
                break;
        }
    }
}
