//������Ҫ�أ�����ֵ��������������


#include <iostream>

using namespace std;
int sum(int,int);
int main()
{   int x,y;
    cin >> x >> y;
    //int result=sum(x,y);
    //cout << result << endl;
    cout << sum(x,y);
    return 0;
}
int sum(int x,int y)
{
    int result=x+y;
    return result;
}
