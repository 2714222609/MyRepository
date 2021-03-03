/*�ж��Ƿ�Ϊ����*/
#include <iostream>

using namespace std;

int main()
{   int year;
    bool isLeapYear;
    cout << "Enter the year" << endl;
    cin >> year;
    isLeapYear=((year%4==0 && year%100!=0) || (year%400==0));
    if (isLeapYear)
        cout << year << "is a LeapYear" << endl;
    else
        cout << year << "is not a LeapYear" << endl;
    return 0;
}
