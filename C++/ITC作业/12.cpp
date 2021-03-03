#include<iostream>
#include<string.h>
using namespace std;
char *strmcpy(char *s,char *t,int m)
{
    int a=strlen(t);
    for(int i=0;i<a-m+1;i++)
       s[i]=t[i+m-1];
    return s;
}
int main()
{
    int m,n;
    char *a,*b;
    a=new char[20];
    b=new char[20];
    cout<<"Input a string:";
    cin.getline(a,20);
    cout<<"Input an integer:";
    cin>>n;
    m=strlen(a);
    cout<<"Output is:";
    char *c=strmcpy(b,a,n);
    for(int i=0;i<m-n+1;i++)
    {
        cout<<c[i];
    }
    return 0;
}

