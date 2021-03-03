#include<iostream>
using namespace std;
int main()
{
	int a[9][9], b[9][9],n,m,count,count1=0;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
			cin >> a[i][j];
	}
	cin >> m;
	for (int i = 0; i < m; i++)
	{
		for (int j = 0; j < m; j++)
			cin >> b[i][j];
	}
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			if (a[i][j] == b[0][0])
			{
				count = 0;
                int x = i, y = j;
				for (int k = 0; k < m; k++,x++)
				{
					y = j;
					for (int l = 0; l < m; l++,y++)
					{
						if (a[x][y] != b[k][l])
						{
							count++;
						}
					}
				}
				if (!count)
				{
					count1++;
					cout << i+1 << ',' << j+1;
					break;
				}
			}
	}
	}
	if (!count1)
		cout << -1;

}
