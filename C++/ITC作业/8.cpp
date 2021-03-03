#include<iostream>
using namespace std;
int main()
{
	int n;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		for (int j = 1; j < n-i; j++)
		{
			cout << ' ';
		}
		cout << '*';
		for (int j = 0; j < n-2+2*i; j++)
		{
			if (!i)
				cout << '*';
			else
				cout << ' ';
		}
		cout << '*';
cout << endl;
	}
	for (int i = 1; i < n; i++)
	{
		for (int j = n; j > n - i; j--)
		{
			cout << ' ';
		}
		cout << '*';
		for (int j = 3*n-4-2*i; j >0 ; j--)
		{
			if (i == n - 1)
				cout << '*';
			else
				cout << ' ';
		}
		cout << '*';
		cout << endl;

	}


}
