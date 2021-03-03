#include<iostream>
using namespace std;
int main()
{
	int a[20] = { 55,2,6,4,32,12,9,73,26,37 },count=0,lastcount=0;
for (int i = 0; i < 10; i++)
		{
	if (i == 9)
		cout << a[i];
	else
			cout << a[i] << ',';
		}
cout << endl << endl << endl;
	for (int i = 0; i < 10; i++)
	{
         lastcount = count;
		for (int j = 0; j < 10 - i-1; j++)
		{
			if (a[j] > a[j + 1])
			{
				int p = a[j];
				a[j] = a[j+1];
				a[j + 1] = p;
				count++;
			}
		}
		if (lastcount != count)
		{
     	for (int i = 0; i < 10; i++)
	    {
		cout << a[i]<<',';
	    }
	    cout << endl;
		}
		else
         {
			break;
		}
		
	}
	for (int i = 0; i < 10; i++)
	{
		cout << a[i] << ',';
	}



}
