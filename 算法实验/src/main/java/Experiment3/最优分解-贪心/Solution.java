package Experiment3.Demo1;

import java.util.Scanner;

public class Solution {

    private static final int MAX = 100000;
    private static int n,k;
    private static int[] a;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        while (true){
            n = input.nextInt();

            a = new int[MAX];

            dicomp();

            long result = 1;
            for(int i=1; i<=k; i++)
                result *= a[i];

            System.out.println(result);
        }
    }

    //将n分成从2开始的连续自然数的和。
    //如果最后剩下一个数，则将此数在后项优先的方式下均匀地分给前面各项
    private static void dicomp(){
        k = 1;
        if(n < 3){
            a[1] = 0;
            return;
        }
        if(n < 5){
            a[k] = 1;
            a[++k] = n-1;
            return;
        }

        a[1] = 2;
        n -= 2;
        while (n > a[k]){
            k++;
            a[k] = a[k-1]+1;
            n -= a[k];
        }
        if(n == a[k]){
            a[k]++;
            n--;
        }
        for(int i=0; i<n; i++) a[k-i]++;
    }
}