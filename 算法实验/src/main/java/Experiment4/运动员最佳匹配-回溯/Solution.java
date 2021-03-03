package Experiment4.Demo3;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int M=100;
        int n=4;
        int c;
        int[][] f=new int[M][M];
        int[] w=new int[M];
        int[] v=new int[M];
        Scanner sc=new Scanner(System.in);
//        System.out.println("请输入背包重量上限");
        c= sc.nextInt();
//        System.out.println("请输入物品的重量和价值");
        for (int i = 0; i < n; i++) {
            w[i]= sc.nextInt();
            v[i]= sc.nextInt();
        }
        for(int i = 1; i <= n; ++i)
        {
            for(int j = w[i]; j <= c; ++j)
            {
                f[i][j] = Math.max(f[i-1][j], f[i-1][j-w[i]]+v[i]);
            }
        }
        System.out.println(f[n][c]);

    }

}
