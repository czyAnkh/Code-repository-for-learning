#pragma once
/********* Start *********/
//���ڴ˴����Complex������
#include<iostream>
using namespace std;
class Complex {
private:
    double real, imag;
public:
    Complex();
    void SetComplex(double re, double im);
    //���ø�����ʵ���鲿   
    Complex operator +(const Complex& c);  //�����ӷ�
    Complex operator -(const Complex& c);  //��������
    Complex& operator =(const Complex& rhs);  //��ֵ�����
    friend ostream& operator<<(ostream& os, const Complex& c);
    //����<<,�����ʽΪ"a+bi"�����b<0�������+�����b==0��������鲿*/
};