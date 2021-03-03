package Experiment1.整数因子分解问题;

import java.util.Scanner;

public class Solution {
    static int[] A = new int[100];

    public static void main(String[] args) {
        int n;
        Scanner scan = new Scanner(System.in);
        System.out.println("Input n: ");
        n = scan.nextInt(); //input n;
        System.out.println(solve(n));

    }
    static int solve(int n){
        int sum = 1;
        if(n < 100 && A[n] != 0) return A[n];

        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                if(i * i == n){
                    sum += solve(i);
                }
                else{
                    sum += solve(i) + solve(n/i);
                }
            }
        }
        if(n < 100){
            A[n] = sum;
        }
        return sum;
    }

}
