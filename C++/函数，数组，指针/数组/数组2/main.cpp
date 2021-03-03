#include <iostream>

using namespace std;

int main()
{   int nums[]{8,4,2,1,23,344,12};
    int numsLen = sizeof(nums)/sizeof(int);
    int max=nums[0];
    int maxIndex = 0;
    for(int i=1;i<numsLen;i++){
            if(nums[i]> max){
                max = nums[i];
                maxIndex = i;}}
                cout << max << "/" << nums[maxIndex] << endl;}

