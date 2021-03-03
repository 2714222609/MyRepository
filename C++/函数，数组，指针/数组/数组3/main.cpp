
#include <iostream>

using namespace std;

int main()
{   int nums[]{8,4,2,1,23,344,12};
    int numsLen = sizeof(nums)/sizeof(int);
    int jCount=0,oCount=0;
    for(int i=0;i<numsLen;i++){
            if(nums[i]%2==0){
                oCount++;}
            else{
                jCount++;}}
    cout << "偶数个数为" << oCount << endl;
    cout << "奇数个数为" << jCount << endl;
    return 0;
}
