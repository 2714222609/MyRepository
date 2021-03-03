#include <iostream>

using namespace std;

int main()
{
    void *ptr;//现在不知道ptr指针是什么类型
    int i=5;
    ptr=&i;
    int *pv =static_cast<int*>(ptr);
    cout << "*pv=" << *pv << endl;
    return 0;
}
