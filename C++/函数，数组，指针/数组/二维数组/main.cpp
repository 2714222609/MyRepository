#include <iostream>

using namespace std;

int main()
{
    //ʹ�ö�ά����
    string stu_names[]{"����","����","�ŷ�"};
    string course_names[]{"����","��ѧ","Ӣ��"};
    const int ROW = 3;//sizeof(stu_names)/sizeof(stu_names[0])
    const int COL = 3;
    double scores[ROW][COL];
    for(int i = 0; i < ROW; i++)
    {
        for(int j = 0;j < COL; j++)
        {
            cout << stu_names[i] << "��" << course_names[j] << "�ɼ���";
            cin >> scores [i][j];
        }
    }
    //��ӡ���
    cout << "\t";
    for (int i =0 ;i < COL; i++)
    {
        cout << course_names[i] << "\t";
    }
    cout << endl;
    for(int i = 0; i < ROW; i++)
    {
        cout << stu_names[i] << "\t";
        for(int j = 0; j < COL; j++)
        {
            cout << scores[i][j] << "\t";
        }
        cout << endl;
    }
}
