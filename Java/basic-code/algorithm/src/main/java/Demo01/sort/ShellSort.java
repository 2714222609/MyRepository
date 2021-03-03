package Demo01.sort;

import static Demo01.tools.Exch.exch;

/*按照一定的间隔来进行插入排序，使得数组越来越接近局部有序，最终使用整体插入排序，时间复杂度O（n^1.3）到O（n²）*/
public class ShellSort {
    public static void shellsort(int[] a) {
        int l = a.length;
        int h = 1;
        while (h < l / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < l; i++) {
                for (int j = i; j >= h && a[j] < a[j - h]; j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}
