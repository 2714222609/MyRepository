#include <iostream>

using namespace std;

int main()
{   int nums []{8,4,2,1,23,344,122};
    int numsLen = sizeof(nums)/sizeof(int);
    int searchNum;
    int searchIndex = INT_MIN;
    cout << "请输入要查找的数字" << endl;
    cin >> searchNum;
    for(int i=0;i<numsLen;i++){
            if(nums[i]==searchNum){
              searchIndex=i;
              break;}}
    if(searchIndex == INT_MIN)
    {
        cout << "数组中没有该数字" << endl;
        }
    else
    {
        cout << searchNum << "在数组中的下标为：" << searchIndex << endl;
    }
    return 0;
    }
