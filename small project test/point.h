#pragma once
/********* Start *********/
//请在此处完成Complex的声明
#include<iostream>
using namespace std;
class Complex {
private:
    double real, imag;
public:
    Complex();
    void SetComplex(double re, double im);
    //设置复数的实部虚部   
    Complex operator +(const Complex& c);  //复数加法
    Complex operator -(const Complex& c);  //复数减法
    Complex& operator =(const Complex& rhs);  //赋值运算符
    friend ostream& operator<<(ostream& os, const Complex& c);
    //重载<<,输出形式为"a+bi"，如果b<0，则不输出+，如果b==0，则不输出虚部*/
};