#include<iostream>
using namespace std;
int main()
{
	int a[20], b[20], n, m, c[50] = { 0 },count=0;
	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> a[i];
     	  cin >> m;
	for (int i = 0; i < m; i++)
		cin >> b[i];
	int i1 = 0;
	for (; i1 < n; i1++)
	{
c[i1] = a[i1];
if (a[i1] == 0)
count++;
	}

	for (int i = 0; i < m; i++, i1++)
	{
c[i1] = b[i];
if (b[i] == 0)
count++;
	}
	for (int i = 0; i < n+m; i++)
	{
		for (int j = i; j < n+m; j++)
		{
			if (c[i] == c[j]&&i!=j)
			{
	        c[j] = 0;
			}
		}
	}
	
	for (int i = 0; i < n + m; i++)
	{
		for (int j = 0; j < n + m-i-1; j++)
		{
			if (c[j] < c[j + 1])
			{
				int p;
				p = c[j];
				c[j] = c[j + 1];
				c[j + 1] = p;
			}
		}
	}
	for (int i = 0; i < n + m; i++)
	{
		if(c[i]!=0)
	cout << c[i] << ' ';
}
	if (count)
		cout << 0;

		
}
