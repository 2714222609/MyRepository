package Experiment1.邮局选址问题;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        System.out.println("How many residents: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println("Input their address: ");
        int[][] A = new int[n][2];
        for(int i = 0; i < n; i++){
            A[i][0] = scan.nextInt();
            A[i][1] = scan.nextInt();
        }
        int[] X = new int[100];
        int[] Y = new int[100];
        for(int i = 0; i < n; i++){
            X[i] = A[i][0];
        }
        for(int i = 0; i < n; i++){
            Y[i] = A[i][1];
        }

        Arrays.sort(X,0,n - 1);
        Arrays.sort(Y,0,n - 1);
//      trace(X,n);
//      System.out.println();
//      trace(Y,n);
        int c1 = X[n/2];
        int c2 = Y[n/2];
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += Math.abs(c1-A[i][0]);
            sum += Math.abs(c2-A[i][1]);
        }
        System.out.println(sum);
    }
//    static void trace(int[][] A, int n){
//        for(int i = 0; i < n; i++){
//            for(int b = 0; b < 2; b++){
//                System.out.print(A[i][b]+" ");
//            }
//            System.out.println();
//        }
//    }
//    static void trace(int[] A, int n){
//        for(int i = 0; i < n; i++){
//            System.out.print(A[i]);
//            System.out.println();
//        }
//    }
}
