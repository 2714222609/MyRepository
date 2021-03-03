#include <iostream>

using namespace std;

int main()
{   int nums[]{8,4,2,1,23,23,344,12};
    int numsLen = sizeof(nums)/sizeof(int);
    int min = nums[0];
    int minIndex = 0;//最小值的初始下标
    for(int i=0;i<numsLen-1;i++)
    {
        min = nums[i];
        minIndex = i;
        for(int j = i+1;j<numsLen;j++)
        {
            if(nums[j]<min)
                {
                min = nums[j];
                minIndex = j;
                }
        }
        if(minIndex > i)
        {
            int temp =nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }

    }
    cout << "排序后： " << endl;
    for(int i=0;i<numsLen;i++)
    {
        cout << nums[i] << endl;
    }
    return 0;
}
