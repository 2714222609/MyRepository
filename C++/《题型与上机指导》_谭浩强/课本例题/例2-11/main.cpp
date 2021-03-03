//编写程序输出比赛的四种情况（胜，负，平，取消）

#include <iostream>
using namespace std;
enum GameResult{WIN,LOSE,TIE,CANCEL};

int main()
{
    GameResult result;
    enum GameResult omit = CANCEL;
    for (int count = WIN; count <= CANCEL; count++)
    {
        result = GameResult(count);
        if(result == omit)
        {
            cout << "This game was cancelled." << endl;
        }
        else
        {
            cout << "The game was played";
            if(result == WIN)
            {
                cout << "and we won." << endl;
            }
            if(result == LOSE)
            {
                cout << "and we lost." << endl;
            }
            cout << endl;
        }
    }
    return 0;
}
