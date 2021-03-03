#include <iostream>
#include <iomanip>
using namespace std;

int main()
{   float h,r,l,s,sq,vq,vz;
    const float PI=3.1415926;
    cout << "please enter r,h" << endl;
    cin >> r >> h;
    l=2*PI*r;
    s=r*r*PI;
    sq=4*PI*r*r;
    vq=3.0/4.0*PI*r*r*r;
    vz=s*h;
    cout << setiosflags(ios::fixed) << setiosflags(ios::right) << setprecision(2);
    cout << "l=" << setw(5) << l << endl;
    cout << "s=" << setw(5) << s << endl;
    cout << "sq=" << setw(5) << sq << endl;
    cout << "vq=" << setw(5) << vq << endl;
    cout << "vz=" << setw(5) << vz << endl;
    return 0;
}
