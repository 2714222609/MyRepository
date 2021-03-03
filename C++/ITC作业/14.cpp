#include<iostream>
#include<stdio.h>
using namespace std;
int main()
{
    char *a=new char[50];
    int b,c,d,e,f;
    b=c=d=e=f=0;
    cout<<"Input a string:";
    gets(a);
    for(int i=0;*(a+i)!='\0';i++)
    {
    if(*(a+i)>='a'&&*(a+i)<='z')
    b++;
    else if(*(a+i)>='A'&&*(a+i)<='Z')
        c++;
    else if(*(a+i)>='0'&&*(a+i)<='9')
        d++;
    else if(*(a+i)==' ')
    e++;
    else
        f++;
    }
cout<<"Number of uppercase letters is :"<<c<<endl;
cout<<"Number of lowercase letters is :"<<b<<endl;
cout<<"Number of spacebars is :"<<e<<endl;
cout<<"Number of digits is :"<<d<<endl;
cout<<"Number of other characters is :"<<f<<endl;
    }

