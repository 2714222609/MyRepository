#include <iostream>

using namespace std;

int main()
{
    void *ptr;//���ڲ�֪��ptrָ����ʲô����
    int i=5;
    ptr=&i;
    int *pv =static_cast<int*>(ptr);
    cout << "*pv=" << *pv << endl;
    return 0;
}
