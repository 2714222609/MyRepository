#include<iostream>
#include<stdio.h>
using namespace std;
int StrLength(char *s);
int main()
{
    int a[5],m=0,count=0;
    cout<<"Input 5 strings:";
    char *p[5];
    for(int i=0;i<5;i++)
    {
        p[i]=new char[50];
        cin>>p[i];
        a[i]=StrLength(p[i]);
    }
    for(int i=0;i<5;i++)
    {
        if(a[i]>m)
        {
            m=a[i];
            count=i;
        }
    }
    cout<<"The longest is:";
    for(int i=0;*(p[count]+i)!='\0';i++)
        cout<<*(p[count]+i);
    return 0;
}
int StrLength(char *s)
{
    int length=0;
    for(int j=0;*(s+j)!='\0';j++)
    {
        length=j+1;
    }
    return length;
}

