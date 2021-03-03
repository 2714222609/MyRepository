#include<iostream>
using namespace std;
int main()
{
	int n,a=0,b=1;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		a += 10;
		b *= 2;
	}
	cout << a * 10000 << endl << b - 1 << endl;



	return 0;
}

