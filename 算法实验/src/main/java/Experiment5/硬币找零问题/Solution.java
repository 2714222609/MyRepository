package Experiment5.Demo3;


import java.util.Scanner;

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        Solution solution = new Solution();
        int result = solution.coinChange(a,m);
        System.out.println(result);
    }
    public int coinChange(int[] a, int m){
        int[] f = new int[m + 1];
        int n = a.length;
        f[0] = 0;
        int i, j;
        for(i = 1; i <= m; i++){
            f[i] = Integer.MAX_VALUE;
            for(j = 0; j < n; j++){
                if(i >= a[j] && f[i - a[j]] != Integer.MAX_VALUE){
                    f[i] = Math.min(f[i - a[j]] + 1, f[i]);
                }
            }
        }
        if(f[m] == Integer.MAX_VALUE){
            f[m] = -1;
        }
        return f[m];
    }
}
