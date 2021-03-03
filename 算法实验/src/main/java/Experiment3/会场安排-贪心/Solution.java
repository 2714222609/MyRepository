package Experiment3.Demo3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int result = greedy(a,b);
        System.out.println(result);
    }
    
    public  static int greedy(int[] a, int[] b){
        int count = 0;
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if(a[i] < b[j]){
                count++;
            }else{
                j++;
            }
        }
        return count;
    }
}
