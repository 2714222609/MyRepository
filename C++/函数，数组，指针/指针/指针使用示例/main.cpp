#include <iostream>

using namespace std;

int main()
{
    char ch='a';
    char* ptr_ch=&ch;
    cout << (string*)ptr_ch << '\t' << *ptr_ch <<endl;
    //Ұָ�룺double ptr_double;Σ�գ���һ��Ҫ��ָ�븳��ֵ
    //double ptr_double=nullptr
    //void*ָ����Դ���������ĵ�ַ
    double objNum= 3.14;
    double *p_objNum =&objNum;
    cout << p_objNum << '\t' << *p_objNum;







    return 0;
}
