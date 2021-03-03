package Experiment4.Demo2;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        //initialize
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] a = new int[n+1][n+1];
        int[][] b = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                b[i][j] = scanner.nextInt();
            }
        }
        //sum of the competitive advantage between male and female players;
        int[][] sum = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n ; j++) {
                sum[i][j] = a[i][j] * b[j][i];
            }
        }
        //search the best competitive advantage;
        int[] max = new int[n+1];
        for (int i = 1; i <= n ; i++) {
            max[i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(sum[i][j] > max[i]){
                    max[i] = sum[i][j];
                }
            }
        }
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += max[i];
        }
        System.out.println(total);
    }
//    public static void trace(int[][] a, int n){
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                System.out.print(a[i][j]);
//            }
//        System.out.println();
//        }
//    }
}
