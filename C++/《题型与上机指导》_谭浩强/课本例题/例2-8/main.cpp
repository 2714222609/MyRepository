/*输入一个整数，求它的所有因子*/

#include <iostream>

using namespace std;

int main(){
    int n;
    cout << "Enter a positive integer:";
    cin >>n;
    cout <<"Number " << n <<" Factors include ";
    for(int k=1;k<=n;k++)
    if(n%k==0){
        cout << k <<" ";}
        return 0;}


