package Experiment2.最少硬币问题;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.min;

public class Solution {
    public static void main(String[] args) {
        int[] coins = new int[11];
        int[] t = new int[11];
        int[] a = new int[1000];

        int n, m;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
            t[i] = sc.nextInt();
        }
        m = sc.nextInt();
        Arrays.fill(a,9999);
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= t[i]; j++) {
                for (int k = m; k >= coins[i]; k--) {
                    a[k] = min(a[k], a[k - coins[i]] + 1);
                }
            }
        }
        System.out.println(a[m]);
    }
}