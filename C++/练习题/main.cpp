#include <iostream>
using namespace std;
int main()
{
    cout << "hello world!";
}



/*
//请编写一个函数int fun(int *s,int t,int *k),用来求出数组的最大
//元素在数组中的下标并存放在k所指的存储单元中。
#include<iostream>
using namespace std;
void fun(int *s,int t,int *k)
{
    int i,max;
    max=s[0];
    for(i=0;i<t;i++)
    {
        if(s[i]>max)
        {
            max=s[i];
            *k=i;
        }
    }
}
int main()
{
    int a[10]={876,675,896,101,301,401,980,431,451,777},k;
    fun(a,10,&k);
    cout << k << endl << a[k] << endl;
}
*/



/*
//请编写一个函数void fun(char a[],char b[],int n),其功能是:
//删除一个字符串中指定下标的字符。其中,a指向原字符串,删
//除后的字符串存放在b所指的数组中,n中存放指定的下标.
#include<iostream>
#define LEN 20
using namespace std;
void fun(char a[],char b[],int n);
int main()
{
    char str1[LEN],str2[LEN];
    int n;
    cout << "Enter the string:\n";
    gets(str1);
    cout << endl << "Enter the position of the string deleted:";
    cin >> n;
    fun(str1,str2,n);
    cout << "The new string is:" << str2 << endl;
}
void fun (char a[],char b[],int n)
{
    int i,k=0;
    for(i=0;a[i]!='\0';i++)
    {
        if(i!=n)
        {
            b[k++]=a[i];
        }
        b[k]='\0';
    }
}
*/




/*
//试编写函数fun，其功能是：求出1到1000之内能够被7或者11整除，但不能同时被7和11整除的数，
//并将他们放在数组a中，依次输出这些数并统计其个数。
#include<iostream>
using namespace std;
#define N 1000
int fun(int a[],int num);
int main()
{
    int a[N]={0};
    int num=0;
    cout << "这样的整数共有" << fun(a,num) << "个" << endl;
    cout << "它们分别是：";
    for(int i=0;i<1000;i++)
    {
        if(a[i]!=0)
        {
            cout << a[i] << '\t';
        }
    }
}
int fun(int a[],int num)
{
    for(int i=1;i<1001;i++)
    {
        if((i%7==0 && i%11!=0)||(i%7!=0 && i%11==0))
        {
            a[i]=i;
            num++;
        }
    }
    return num;
}
*/



/*
//m个人的成绩存放在score数组中,请编写函数fun,它的功能是:将低于平均分的人数作为函数值返回,
//将低于平均分的分数放在below所指的数组中,并输出。
#include<iostream>
using namespace std;
int fun(int [],int,int []);
int main()
{
    int score[9]={10,20,30,40,50,60,70,80,90};
    int sum=0;
    for(int i=0;i<9;i++)
    {
        sum+=score[i];
    }
    int average=sum/9;
    int below[9]={0};
    cout << "低于平均分的人数有：";
    cout << fun(score,average,below) << endl;
    cout << "低于平均分的分数为：";
    for(int i=0;i<9;i++)
    {
        if(below[i]!=0)
        {
            cout << below[i] << " ";
        }
    }
}
int fun(int score[],int average,int below[])
{
    int num=0;
    for(int i=0;i<9;i++)
    {
        if(score[i]<average)
        {
            below[i]=score[i];
            num++;
        }
    }
    return num;
}
*/



/*
//编写程序将一个一位数组逆置并输出
#include <iostream>
using namespace std;
int main()
{
    int i;
    cout << "请输入数组长度：";
    cin >> i;
    cout << endl;
    int *ptr=new int [i];
    cout << "请输入原数组：";
    for(int j=0;j<i;j++)
    {
        cin >> *(ptr+j);
    }
    cout << endl << "原数组为：";
    for(int j=0;j<i;j++)
    {
        cout << *(ptr+j) << " ";
    }
    cout << endl << "逆置后的数组为：";
    for(int j=0,s=i-1;j<i/2;j++,s--)
    {
        int t=*(ptr+j);
        *(ptr+j)=*(ptr+s);
        *(ptr+s)=t;
    }
    for(int j=0;j<i;j++)
    {
        cout << *(ptr+j) << " ";
    }
    return 0;
}
*/





/*
//输入一个字符串，将其中的a用*代替，并输出新的字符串
#include <iostream>
#include <cstring>
using namespace std;
int main()
{
    char b[20];
    cout << "请输入字符串：";
    gets(b);
    int n=strlen(b);
    for(int i=0;i<n;i++)
    {
        if(b[i]=='a')
        {
            b[i]='*';
        }
    }
    cout << "新的字符串为：" << b;
    return 0;
}
*/




/*
//已知a,b,c都是1位整数，求当三位整数abc，cba的和为1333时a,b,c的值。
#include<iostream>
using namespace std;
int main()
{
    int a,b,c;
    for(a=0;a<=9;a++)
    {
        for(b=0;b<=9;b++)
        {
            for(c=0;c<=9;c++)
            {
                int m=(a*100+b*10+c);
                int n=(c*100+b*10+a);
                if(m+n==1333)
                {
                    cout << "a=" << a << " " << "b=" << b << " " << "c=" << c << endl;
                }
            }
        }

    }
}
*/





/*
//求100之内最大的能被17整除的自然数
#include<iostream>
using namespace std;
int main()
{
    int i=100;
    for(i; ;i--)
    {
        if(i%17==0)
        {
            cout << i << endl;
            break;
        }

    }
}
*/




/*
//写长方体类并求出其体积
#include<iostream>
using namespace std;
class Rectangle
{
private:
    float length;
    float width;
    float height;
    float V;
public:
    void setrec();
    void show();
    float calculateV();

};
void Rectangle::setrec()
{
    float l,w,h;
    cout << "请依次输入长方体的长、宽、高：";
    cin >> l >> w >> h;
    length=l;
    width=w;
    height=h;
}
float Rectangle::calculateV()
{
    V=length*width*height;
    return V;
}
void Rectangle::show()
{
    cout << "长方体的长宽高分别为：" << length << " " << width << " " << height << endl;
    cout << "长方形的体积为：" << V << endl;
}
int main()
{
    Rectangle r1;
    r1.setrec();
    r1.calculateV();
    r1.show();
    return 0;
}
*/



/*
//给出年，月，日，计算该日是该年的第几天
#include<iostream>
using namespace std;
int main()
{
    int sum_day(int ,int );
    int leap(int year);
    int year,month,day,days;
    cout << "input date(year,month,day):";
    cin >> year >> month >> day;
    cout << year << "/" << month << "/" << day;
    days=sum_day(month,day);
    if(leap(year) && month>=3)
        days=days+1;
    cout << " is the " << days << "th day in this year." << endl;
    return 0;
}
int sum_day(int month,int day)
{
    int day_tab[12]={31,28,31,30,31,30,31,31,30,31,30,31};
    for(int i=0;i<month-1;i++)
    {
        day=day+day_tab[i];
    }
     return (day);
}
int leap(int year)
{
    int leap;
    leap=year%4==0&&year%100!=0||year%400==0;
    return (leap);
}
*/



/*
//打印杨辉三角形
#include<iostream>
#include<iomanip>
using namespace std;
int main()
{
    const int n=11;
    int a[n][n];
    for(int i=1;i<n;i++)
    {
        a[i][1]=1;
        a[i][i]=1;
    }
    for(int i=3;i<n;i++)
    {
        for(int j=2;j<=i-1;j++)
        {
            a[i][j]=a[i-1][j-1]+a[i-1][j];
        }
    }
    for(int i=1;i<n;i++)
    {
        for(int j=1;j<=i;j++)
        {
            cout << setw(6) << a[i][j] << " ";
        }
        cout << endl;
    }
    return 0;

}
//本题关键在于怎样表示杨辉三角形中的每个元素
*/



/*
//将一个数组中的值按照逆序重新排放
#include<iostream>
#define N 5
using namespace std;
int main()
{
    int a[N];
    cout << "Please input the array：";
    for(int i=0;i<N;i++)
    {
        cin >> a[i];
    }
    cout << endl << "The array:" << endl;
    for(int i=0;i<N;i++)
    {
        cout << a[i] << " ";
    }
    int temp;
    for(int i=0;i<N/2;i++)
    {
        temp=a[i];
        a[i]=a[N-i-1];
        a[N-i-1]=temp;
    }
    cout << endl << "The new array is:" << endl;
    for(int i=0;i<N;i++)
    {
        cout << a[i] << " ";
    }
    return 0;
}
//本题关键在于怎样将一个数组逆序:temp=a[i];a[i]=a[n-i-1];a[n-i-1]=temp;
*/




/*
//有一个已经排序的数组，插入一个值，重新排序
#include<iostream>
using namespace std;
int main()
{
   int a[11]={1,6,13,17,28,40,56,78,89,100};
   int num,i,j;
   cout << "array a:" << endl;
   for(i=0;i<10;i++)
   {
       cout << a[i] << " ";
   }
   cout << endl;
   cout << "insert data:";
   cin >> num;
   if(num>a[9])
   {
       a[10]=num;
   }
   else
   {
       for(i=0;i<10;i++)
       {
           if(a[i]>num)
           {
               for(j=9;j>=i;j--)
               {
                   a[j+1]=a[j];
               }
               a[i]=num;
               break;
           }
       }
   }
   cout << "Now the new array is:" << endl;
   for(i=0;i<11;i++)
   {
       cout << a[i] << " ";
   }
   return 0;
}
//本题关键在于怎样实现元素的插入，方法是将插入位之后的元素通通向后移动一位，
//然后插入该元素
*/




/*
//求一个三乘三矩阵的主对角线元素之和
#include<iostream>
using namespace std;
int main()
{
    int a[3][3],sum=0;
    cout << "请输入3x3矩阵：";
    for(int i=0;i<3;i++)
    {
        for(int j=0;j<3;j++)
        {
            cin>>a[i][j];
        }
    }
    for(int i=0;i<3;i++)
    {
        sum+=a[i][i];
    }
    cout << "矩阵的主对角线元素之和为："<< sum << endl;
    return 0;
}
//关键之处在于用a[i][i]来表示主对角线元素；
*/




/*
//用选择排序法进行排序
#include <iostream>

using namespace std;

int main()
{
    int i,j,min,temp,a[11];
    cout << "enter data:"<<endl;
    for(int i=1;i<=10;i++)
    {
        cout << "a[" << i << "]=";
        cin >> a[i];
    }
    cout << endl << "The original numbers:" << endl;
    for(i=1;i<=10;i++)
        cout<<a[i]<<" ";
    cout<<endl;
    for(i=1;i<=9;i++)
    {
        min=i;
        for(j=i+1;j<=10;j++)

            {if(a[min]>a[j])
                {min=j;}}
            temp=a[i];
            a[i]=a[min];
            a[min]=temp;

    }
    cout << endl << "The sorted numbers:"<<endl;
    for(i=1;i<=10;i++)
        cout << a[i] << " ";
    cout << endl;
    return 0;
}
*/
