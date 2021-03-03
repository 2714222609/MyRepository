package Demo01.sort;

import static Demo01.tools.Exch.exch;

/*每次选出一个最小的往前放，将该元素放到合适的位置，时间复杂度O（n²）*/
public class SelectionSort {
    public static void selectionsort(int[] a) {
        int l = a.length;
        for (int i = 0; i < l; i++) {
            int min = i;
            for (int j = i + 1; j < l; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }
}
