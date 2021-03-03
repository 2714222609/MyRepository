package Experiment1.输油管道问题;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        System.out.println("How many oil well: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println("Input their address: ");
        int[][] A = new int[n][2];
        for(int i = 0; i < n; i++){
            A[i][0] = scan.nextInt();
            A[i][1] = scan.nextInt();
        }
        int[] Y = new int[100];
        for(int i = 0; i < n; i++){
            Y[i] = A[i][1];
        }
        Arrays.sort(Y,0,n - 1);
        int c2 = Y[n/2];
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += Math.abs(c2-A[i][1]);
        }
        System.out.println(sum);
    }
}