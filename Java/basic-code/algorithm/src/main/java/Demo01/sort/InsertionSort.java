package Demo01.sort;

import static Demo01.tools.Exch.exch;

/*每次将i与i之前的数比较，如果比前面的数小，就和前面的数交换，将i对应的元素放到合适的位置，时间复杂度O（n²）*/
public class InsertionSort {
    public static void insertionsort(int[] a) {
        int l = a.length;
        for (int i = 1; i < l; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                exch(a, j, j - 1);
            }
        }
    }
}
