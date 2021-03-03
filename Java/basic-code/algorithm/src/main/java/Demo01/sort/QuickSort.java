package Demo01.sort;

import Demo01.tools.Exch;
/*首先选定一个基准，头指针指向数组头部，尾指针指向数组尾部，然后开始移动头指针和尾指针，
* 通过交换，将比基准小的元素放在基准的左侧，比基准大的元素放在基准的右侧，一轮交换之后
* 基准的位置确定，在其左侧和右侧重复以上步骤。*/
public class QuickSort {
    public static void quickSort(int[] a,int low,int high){
        int i = low;
        int j = high;
        int key = a[i];
        while(i < j){
            while(a[j] >= key && i < j){
                j--;
            }
            if(i < j){
                Exch.exch(a,i,j);
            }
            while(a[i] <= key && i < j){
                i++;
            }
            if(i < j){
                Exch.exch(a,i,j);
            }
            quickSort(a,low,i-1);
            quickSort(a,i+1,high);
        }
    }
    public static void quickSort(int[] a){
        int low = 0;
        int high = a.length - 1;
        quickSort(a,low,high);
    }
}
