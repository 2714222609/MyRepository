package Demo01.sort;

import static Demo01.tools.Exch.exch;

/*每次比较i和i+1，将打大的数往下沉，一次循环可以将最大的数沉到末尾，时间复杂度O（n²）*/
public class BubbleSort {
    public static void bubblesort(int[] a) {
        int l = a.length;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    exch(a, j, j + 1);
                }
            }
        }
    }
}
