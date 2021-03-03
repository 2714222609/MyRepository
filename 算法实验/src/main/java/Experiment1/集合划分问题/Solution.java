package Experiment1.集合划分问题;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int m, n;
        int count = 0;
        System.out.println("How many elements: ");
        n = new Scanner(System.in).nextInt();
        for(m = 1; m <= n; m++){
            count +=set(n,m);
        }
        System.out.println(count);
    }
    static int set(int n, int m){
        if(m == n || m == 1)
            return 1;
        return set(n - 1, m - 1) + m * set(n - 1, m);
    }
}
