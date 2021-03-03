#include <iostream>
using namespace std;

int main ()
{
   int i=2;
   while(i<100)
   {
       int flag = 0;
       int j = 2;
       while(j<i)
       {
           if(i%j==0)
           {
               flag++;
           }
           j++;
       }
       if(flag==0)
        cout << i << " ";
       i++;
   }
    return 0;
}
