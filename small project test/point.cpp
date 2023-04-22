/********* Start *********/
//请在此处完成Complex的定义
#include<iostream>
#include"complex.h"
using namespace std;
Complex::Complex()
{

}
void Complex::SetComplex(double re, double im)
{
    real = re; imag = im;
}
Complex Complex::operator +(const Complex& c)
{
    Complex t;
    t.real = this->real + c.real;
    t.imag = this->imag + c.imag;
    return t;
}
Complex Complex::operator -(const Complex& c)
{
    Complex t;
    t.real = this->real - c.real;
    t.imag = this->imag - c.imag;
    return t;
}
Complex& Complex::operator =(const Complex& rhs)
{
    this->imag = rhs.imag;
    this->real = rhs.real;
    return *this;
}
ostream& operator<<(ostream& os, const Complex& ra) {
    if (ra.imag < 0)cout << ra.real << ra.imag << "i";
    else if (ra.imag > 0)cout << ra.real << "+" << ra.imag << "i";
    else if (ra.imag == 0)cout << ra.real;
    return os;
}