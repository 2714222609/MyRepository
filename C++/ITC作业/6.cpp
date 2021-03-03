#include<iostream>
#include<string>
#include<string.h>
using namespace std;
int main()
{
	int c,e,count=0,q=0;
	char* a, * b,d[50];
	a = new char[50];
	b = new char[50];
	cin.getline(a, 50);
	cin.getline(b, 50);
	c = strlen(a);
	e = strlen(b);
	for (int i = 0; i < c; i++)
	{
		for (int j = 0; j < e; j++)
		{
			if (*(a + i) == *(b + j))
			{
				*(a + i) = ' ';
				q++;
			}
			if (*(a + i) == *(a + j) && i!=j)
			{
            *(a + j) = ' ';
			q++;
			}
		}
	}
	for (int i = 0; i < c; i++)
	{
		if (*(a + i) != ' ')
		{
			d[count]=*(a + i);
			count++;
		}
	}
	for (int i = 0; i < count-1; i++)
	{
		for (int j = 0; j < count - i-1; j++)
		{
			if (d[j] > d[j + 1])
			{
				int p;
				p = d[j];
				d[j] = d[j + 1];
				d[j + 1] = p;
			}
		}
	}
	if(q==0)
    {
        cout << "NULL";
    }
	for (int i = 0; i < count; i++)
	{
		if (q != 0)
			cout << d[i];
	}


}




