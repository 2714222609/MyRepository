#include <iostream>

using namespace std;

int main()

{   int sum =0;
    int nums[]{8,4,2,1,23,344,12};
    int numsLen = sizeof(nums) / sizeof(int);  //计算数组的长度
    for(int i=0;i<numsLen;i++){
            cout << nums [i] << endl;}
    cout << endl;
    for(int i=0;i<numsLen;i++){
            sum+=nums[i];}
    cout << sum << endl;
    cout << sum/numsLen << endl;
    return 0;
}
