package Demo01.sort;

/*先递归的将数组分成两半，分到只剩一个时，在分别排序，然后再归并起来，时间复杂度O（nlogn）*/
public class MergeSort {
    private static int[] aux; //归并所需的辅助数组

    public static void sort(int[] a) {
        aux = new int[a.length]; //为辅助数组分配空间
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid); //将左半边排序
        sort(a, mid + 1, hi); //将右半边排序
        merge(a, lo, mid, hi); //归并结果
    }

    public static void merge(int[] a, int lo, int mid, int hi) {
        //merge a[lo..mid] and a[mid+1..hi]
        int i = lo, j = mid + 1;
        if (hi + 1 - lo >= 0) System.arraycopy(a, lo, aux, lo, hi + 1 - lo);
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (aux[j] < aux[i]) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }
}
