#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    vector<double> vecDouble = {99.5,67.9,43.6,32.9};
    //�������в�������
    vecDouble.push_back(100.8);//�������β������һ������
    //��ӡ1
    for (int i=0; i<vecDouble.size(); i++)
    {
        cout << vecDouble[i] << endl;
    }
    /*ʹ�õ����� iterator
    vector<double>::iterator it;//���õ���������ʵ������һ��ָ�����
    //�ӵ�һ��Ԫ�ؿ�ʼ����
    for(it=vecDouble.begin(); it��=vecDouble.end();++it)
    {
        cout << *it << endl;
    }*/
    //����
    sort(vecDouble.begin(),vecDouble.end());
    //����reverse(vecDouble.begin(),vecDouble.end());
    for (int i=0; i<vecDouble.size(); i++)
    {
        cout << vecDouble[i] << endl;
    }

     return 0;
}
