#include<iostream>
using namespace std;
int main()
{
    int a,b,sum,sum1;
    sum=sum1=1;
    cin>>a>>b;
    cout<<a<<',';
    for(int i=a-1;i>=2;i--)
    {
        if(a%i==0)
        {
            sum+=i;
            cout<<i<<'+';
        }
    }
    cout<<1<<'='<<sum<<endl;
    cout<<b<<',';
for(int i=b-1;i>=2;i--)
{
    if(b%i==0)
    {
        sum1+=i;
        cout<<i<<'+';
    }
}
    cout<<1<<'='<<sum1<<endl;
    if(sum==b)
        cout<<1;
    else
        cout<<0;
    return 0;
}



