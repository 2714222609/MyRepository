/*输入一个0-6的整数，转换成星期输出*/
#include <iostream>

using namespace std;

int main(){
    int day;
    cin >> day;
    switch (day){
case 0:
    cout << "Sunday" << endl;
    break;
case 1:
    cout << "Monday" << endl;
    break;
case 2:
    cout << "Tuesday" << endl;
    break;
case 3:
    cout << "Wednesday" << endl;
    break;
case 4:
    cout << "Thursday" << endl;
    break;
case 5:
    cout << "Saturday" << endl;
    break;
case 6:
    cout << "Saturday" << endl;
    break;
default:
    cout << "Day out of range Sunday--Saturday" << endl;
    break;}
    return 0;}


