package Experiment5.Demo2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        //分数背包问题放的东西是连续的,不是离散的
        Scanner scan = new Scanner(System.in);
        //count 物品数量 space 背包容量 value 存储各物品的价值 volume 存储各物品的大小
        int count = scan.nextInt();
        int space = scan.nextInt();
        int[] value = new int[count];
        int[] volume = new int[count];
        for(int i=0;i<count;i++){
            value[i] = scan.nextInt();
        }
        for(int i=0;i<count;i++){
            volume[i] = scan.nextInt();
        }
        //pivot 存储每个物品的 价值/体积 系数
        List<Float> list = new ArrayList<>();
        for(int i=0;i<count;i++){
            list.add((float)value[i]/volume[i]);
        }
        //worth 背包里获得的物品价值 temp 目前背包里装的物品总体积
        float worth = 0f;
        int temp = 0;
        //贪心算法核心,每次找到价值/体积的最大的物品
        while (temp < space){
            int index = maxList(list);
            if(volume[index] <= space-temp){
                worth += value[index];
                temp += volume[index];
                list.set(index,0f);
            }
            else {
                worth += list.get(index)*(space-temp);
                temp = space;
            }
        }
        System.out.println(worth);
    }
    public static int maxList(List<Float> list){
        Float Max = 0f;
        int index = 0;
        for(int i=0;i<list.size();i++){
            if(list.get(i) > Max){
                Max = list.get(i);
                index = i;
            }
        }
        return index;
    }
}
