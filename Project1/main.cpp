#include <iostream>
#include<list>
using namespace std;
int main()
{
	for (int i = 2; i < 1000; i++)
	{
		for (int j = 2; j < i; j++)
		{
			if (i % j == 0) break;
			if(j==i-1)
			{
				cout << i << " "; break;
			}
		}
	}
}