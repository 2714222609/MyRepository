#include <iostream>

using namespace std;

int main()
{   int nums []{8,4,2,1,23,344,122};
    int numsLen = sizeof(nums)/sizeof(int);
    int searchNum;
    int searchIndex = INT_MIN;
    cout << "������Ҫ���ҵ�����" << endl;
    cin >> searchNum;
    for(int i=0;i<numsLen;i++){
            if(nums[i]==searchNum){
              searchIndex=i;
              break;}}
    if(searchIndex == INT_MIN)
    {
        cout << "������û�и�����" << endl;
        }
    else
    {
        cout << searchNum << "�������е��±�Ϊ��" << searchIndex << endl;
    }
    return 0;
    }
