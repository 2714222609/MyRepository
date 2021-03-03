
#include<iostream>

using namespace std;
void findmax(int arr[]);
int Max=0;
int index=0;
int main()

{

	int arr[10]={80,91,21,3,23,42,13,43,64,6};
	findmax(arr);

}
void findmax(int arr[])
{
    for(int i=0; i<10;i++)
    {
       if(arr[i]>Max)
       {
          Max=arr[i];
          index=i;
       }
    }



    cout <<"the index of maximum element is " << index << endl;
    cout << "the value of it is " << Max << endl;
}

