package Experiment4.Demo1;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        //input data
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        //sort and reverse
        Arrays.sort(a);
        int temp;
        for (int i = 0, j = n - 1; i < j; i++,j--) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        //Each time select the maximum number in array a, add it to the minimum number in array b;
        int[] b = new int[k];
        for (int i = 0; i < k; i++) {
            b[i] = 0;
        }
        for(int i = 0; i < n; i++){
            Arrays.sort(b);
            b[0] = b[0] + a[i];
        }
        //The last number in array b is the answer;
        System.out.println(b[k-1]);
    }
}
