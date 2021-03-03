#include<iostream>
using namespace std;
int main()
{
	int m, n, a[100] = { 1,0 }, b[100] = { 1,0 }, count,count1, sum,sum1,luanshen[50]={0},k=1;
	cin >> m >> n;
	for (int i = m; i <= n; i++)
	{
		sum1=sum = 0;
		count1=count = 1;
		for (int j = 1; j < 50; j++)
		{
			a[j] = b[j] = 0;
		}
		for (int j = 2; j < i; j++)
		{
			if (i % j == 0)
			{
				a[count] = j;
				count++;
			}
		}
		for (int j = 0; a[j] != 0; j++)
		{
			sum += a[j];
		}
		for (int j = 2; j < sum; j++)
		{
			if (sum % j == 0)
			{
				b[count1] = j;
				count1++;
			}
		}
		for (int j = 0; b[j] != 0; j++)
		{
			sum1 += b[j];
		}
		if (i == sum1&&i!=sum&&i!=luanshen[k-2]&&sum>m)
		{
            cout << i << ' ' << sum<< endl;
			luanshen[k - 1] = sum;
			k++;
		}
	}
	if (!(k - 1))
		cout << "NONE";

}
