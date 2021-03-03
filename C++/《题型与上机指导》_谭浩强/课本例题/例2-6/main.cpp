/*输入一个整数，将各位数字反转后输出*/
#include <iostream>

using namespace std;

int main(){
    int n,right_dight,newnum=0;
    cout << "Enter the number:";
    cin >> n;
    cout << "The number in reverse is";
    do{
       right_dight=n%10;
       cout << right_dight;
       n=n/10;
       }while(n!=0);
       cout << endl;
       return 0;}
