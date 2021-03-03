#include<iostream>
using namespace std;
#define N 10
#define M 10
void Transpose1(int a[][N], int at[][M], int m, int n);
void Transpose2(int(*a)[N], int(*at)[M], int m, int n); 
void Transpose3(int* a, int* at, int m, int n);  
int main()
{
	int m, n, a[N][M], b[N][M];
	cin >> m >> n;
	for (int i = 0; i < m; i++)
	{
		for (int j = 0; j < n; j++)
		{
			cin >> a[i][j];
		}
	}
	Transpose1(a, b, m, n);
	Transpose2(a, b, m, n);
	Transpose3(a[0], b[0], m, n);
	return 0;
}
void Transpose1(int a[][N], int at[][M], int m, int n)
{
	for (int i = 0; i < m; i++)
	{
		for (int j = 0; j < n; j++)
		{
		 at[j][i] =a[i][j];
		}
	}
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cout << at[i][j]<<' ';
		}
		cout << endl;
	}

}
void Transpose2(int(*a)[N], int(*at)[M], int m, int n)
{
	for (int i = 0; i < m; i++)
	{
		for (int j = 0; j < n; j++)
		{
		 *(at[j]+i)=*(a[i]+j) ;
		}
	}
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cout << *(at[i] + j)<<' ';
		}
		cout << endl;
	}
}
void Transpose3(int* a, int* at, int m, int n)
{
	for (int i = 0; i < m; i++)
	{
		for (int j = 0; j < n; j++)
		{
		*(at+j*N+i)=*(a+i*N+j);
		}
	}
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cout << *(at + i * N + j)<<' ';
		}
		cout << endl;
	}



}
