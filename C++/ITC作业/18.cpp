#include<iostream>
#include<string.h>
using namespace std;
int main()
{
	int count = 0, count1[5] = { 0 }, count2 = 0;
	char* a = new char[50];
	char* b = new char[20];
	cin.getline(a, 50);
	cin.getline(b, 20);
	for (int i = 0; i < strlen(a)-strlen(b)+1; i++)
	{
		count = 0;
		for (int j = 0; j < strlen(b); j++)
		{
			if (*(a + i + j) == *(b + j))
			{
				count++;
			}
		}
		if (count == strlen(b))
		{
			count1[count2] = i;
			count2++;
		}
	}
	for (int k = 0; k < count2; k++)
	{
		for (int i = 0; i < strlen(b); i++)
        {
	   	*(a + count1[k] + i) = '#';
       	}
	}
	for (int i = 0; *(a + i) != '\0'; i++)
	{
		if(*(a+i)!='#')
        cout << *(a+i);
	}
	
}
