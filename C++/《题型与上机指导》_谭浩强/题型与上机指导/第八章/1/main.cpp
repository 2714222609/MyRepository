#include <iostream>
using namespace std;
class Student
{
private:
    int num;
    float score;
public:
    Student(int n,float s):num(n),score(s){}
    void display();
};
void Student::display()
{
    cout << num << " " << score << endl;
}
int main()
{
    Student student[5]={Student(101,78.5),Student(102,85.5),Student(103,98.5),Student(104,94),Student(105,54)};
    Student *ptr=student;
    for(int i=0; i<=2; ptr=ptr+2,i++)
    {
        ptr->display();
    }
    return 0;}
