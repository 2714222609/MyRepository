package Demo01;

import Demo01.sort.BubbleSort;
import Demo01.sort.MergeSort;
import Demo01.sort.QuickSort;
import Demo01.sort.ShellSort;
import java.util.Random;
import static Demo01.tools.Trace.trace;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[100];
        for (int i = 0; i < 100; i++) {
            a[i] = new Random().nextInt(1000);
        }

        System.out.print("before sort: ");
        trace(a);

        long startTime = System.currentTimeMillis(); // 计算耗费的时间
        //InsertionSort.insertionsort(a);
        //SelectionSort.selectionsort(a);
        //BubbleSort.bubblesort(a);
        //ShellSort.shellsort(a);
        //MergeSort.sort(a);
        QuickSort.quickSort(a);
        long endTime = System.currentTimeMillis();

        System.out.print("\nafter sort: ");
        trace(a);

        long time = endTime - startTime;
        System.out.println("\ntime cost: " + time + "ms");
    }
}
