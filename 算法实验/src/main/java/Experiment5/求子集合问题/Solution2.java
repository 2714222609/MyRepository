package Experiment5.Demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
    public static int space = 0;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scan.nextInt();
        }
        space = scan.nextInt();
        int[] count = new int[1];
        List<Integer> list = new ArrayList<>();
        backtrack(arr,0,0,count,list);
        System.out.println(count[0]);
    }

    public static void backtrack(int[] arr, int k,int cost,int[] count,List<Integer> list){
        //达到边界条件,直接返回
        if(cost == space){
            for(int i: list){
                System.out.print(i+" ");
            }
            System.out.println();
            count[0]++;
            return;
        }
        /*否则,若达到剪枝条件,封死
          再则,深入下一步搜索*/
        /*剪枝条件,超过末尾 或 当前代价加上后一个数大于总空间
          深入方法,更新代价,深度+1
         */
        if(k < arr.length){
            if (cost + arr[k] <= space) {
                for (int i = k; i < arr.length; i++) {
                    cost += arr[i];
                    list.add(arr[i]);
                    backtrack(arr, i + 1, cost, count,list);
                    cost -= arr[i];
                    list.remove(Integer.valueOf(arr[i]));
                }
            }
        }
    }
}
