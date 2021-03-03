package Experiment1.众数问题;
/*
* basic ideas:1.find the median, by moving a left pointer and a right pointer to see whether median is the longest.
*             2.if the median is not the longest, do recursion at the left array and right array.
* */
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Solution {
    static final int N = 1000;
    static int[] A = new int[N];
    static int num,v;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input the length of the array:");
        int n = scan.nextInt(); //input the length of array;

        Random rand = new Random();
        for(int i = 0; i < n; i++){
            A[i] = (rand.nextInt(100 + 1)) % 20;
        } //generate random array;

        System.out.println("before sort: ");
        trace(A, n);

        System.out.println("\nafter sort: ");
        Arrays.sort(A,0,n);
        trace(A, n);//trace

        solve(0, n - 1);
        System.out.println("\nValue: " + v);
        System.out.println("Number: " + num);
    }

    static void trace(int[] A, int n){
        for(int i = 0; i < n; i++){
            if(i > 0) System.out.print(" ");
            System.out.print(A[i]);
        }
    }

    static void solve(int l, int r) {
        if (l > r)
            return;
        int mid = (l + r) / 2;//find the median;
        int i = mid;
        int j = mid;

        while(i >= 0 && A[i] == A[mid]){
            i--;
        }
        while(A[j] == A[mid] && j <= A.length - 1){
            j++;
        }//to see whether median is the v;

        if(j - i - 1 > num){
            num = j - i - 1;
            v = A[mid];
        }
        if(i - l + 1 > num){
            solve(l, i);
        }
        if(r - j + 1 > num){
            solve(j, r);
        }

    }
}
