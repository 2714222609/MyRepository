#include<iostream>
using namespace std;
int main()
{
	int a,b,c,d,e,f;
	for ( a = 0; a <2;a++ )
	{
		for ( b = 0; b < 2; b++)
		{
			for ( c = 0; c < 2; c++)
			{
				for (d = 0; d < 2; d++)
				{
					for (e = 0; d < 2; d++)
					{
						for (f = 0; f < 2; f++)
						{
							bool g = ((a + b) >= 1 && (a + e + f) >= 2 && (a + d) <= 1);
							bool h = ((b + c) % 2 == 0 && (c + d) == 1);
							if (g && h)
							{
								if (e == 0 && d == 1)
									continue;
								else
								{
									if (a)
										cout << 'A';
									if (b)
										cout << 'B';
									if (c)
										cout << 'C';
									if (d)
										cout << 'D';
									if (e)
										cout << 'E';
									if (f)
										cout << 'F';
								}
							}
						}
					}
				}
			}
		}
	}




		
}
