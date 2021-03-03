package Experiment3.Demo2;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int sum = 0;
        int count = 0;
        for(int i = 0; i < n; i++){
            sum += a[i];
            if(sum < l){
                count++;
            }
        }
        System.out.println(count);
    }
}
