package Experiment2.独立任务最优调度问题;
import java.util.Scanner;

public class Solution {
    public static int minTime(int[] a, int [] b,int n) {
        int sa = 0;
        int sb = 0;
        int T = 0;
        for (int i = 0; i < n; i++) {
            if ((sa + a[i] < sb + b[i]) && (sa + a[i] > T)) {
                sa += a[i];
                T = sa;
            } else if ((sb + b[i] < sa + a[i]) && (sb + b[i] > T)) {
                sb += b[i];
                T = sb;
            } else {
                if ((sa + a[i] < sb + b[i]) && (sb + b[i] < T)) {
                    sb += b[i];
                } else if ((sb + b[i] < sa + a[i]) && (sb + b[i] < T)) {
                    sb += b[i];
                }
            }
        }
        return T;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []a = new int[n];
        int []b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int j = 0; j < n; j++) {
            b[j] = sc.nextInt();
        }
        int min = minTime(a,b,n);
        System.out.println(min);
    }
}
