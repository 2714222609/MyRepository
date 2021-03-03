#include <iostream>

using namespace std;
int power (int,int);
int main()
{   int x,n;
    cin >> x >> n;
    cout << power(x,n);
    return 0;
}
int power(int x, int n)
{   int num = 1;
    while(n!=0)
    {
        num = num*x;
        n--;
    }
    return num;
}
