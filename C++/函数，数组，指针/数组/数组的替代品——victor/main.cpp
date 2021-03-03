#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    vector<double> vecDouble = {99.5,67.9,43.6,32.9};
    //向数组中插入数字
    vecDouble.push_back(100.8);//在数组的尾部插入一个数字
    //打印1
    for (int i=0; i<vecDouble.size(); i++)
    {
        cout << vecDouble[i] << endl;
    }
    /*使用迭代器 iterator
    vector<double>::iterator it;//的用迭代器对象，实际上是一个指针对象！
    //从第一个元素开始迭代
    for(it=vecDouble.begin(); it！=vecDouble.end();++it)
    {
        cout << *it << endl;
    }*/
    //排序
    sort(vecDouble.begin(),vecDouble.end());
    //逆序：reverse(vecDouble.begin(),vecDouble.end());
    for (int i=0; i<vecDouble.size(); i++)
    {
        cout << vecDouble[i] << endl;
    }

     return 0;
}
