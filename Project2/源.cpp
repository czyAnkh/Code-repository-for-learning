#include<iostream>
using namespace std;

int* p = NULL;
int& foo()
{
	int a = 10;
	return a;
}

void main()
{
	p = &foo();
	cout << *p << endl;
	cout << *p << endl;
}