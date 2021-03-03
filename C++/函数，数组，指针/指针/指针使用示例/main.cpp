#include <iostream>

using namespace std;

int main()
{
    char ch='a';
    char* ptr_ch=&ch;
    cout << (string*)ptr_ch << '\t' << *ptr_ch <<endl;
    //野指针：double ptr_double;危险！！一定要给指针赋初值
    //double ptr_double=nullptr
    //void*指针可以存放任意对象的地址
    double objNum= 3.14;
    double *p_objNum =&objNum;
    cout << p_objNum << '\t' << *p_objNum;







    return 0;
}
