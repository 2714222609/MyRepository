package Experiment5.Demo1;

import java.util.Scanner;

import java.util.ArrayList;

public class Solution {
    public static int  [] num;
    public static int min = Integer.MAX_VALUE;
    public static String str = "";
    public static int sum = 0,c;
    public static boolean [] bool;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        c = sc.nextInt();
        num = new int [n+1];
        bool = new boolean [n+1];
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <=n; i++) {
            num[i]=sc.nextInt();
        }
        f(0,list);
        System.out.println(str);
    }
    public static void f(int a,ArrayList<Integer> list){
        if(sum==c){
            int sum = 0;
            for (int i = 0; i <list.size(); i++) {
                sum=list.get(i)+sum;
            }
            if(sum<min){
                str = "";
                min=sum;
                for (int i = 0; i < list.size(); i++) {
                    str=str+num[list.get(i)]+" ";
                }
            }
            return;
        }
        for (int i = 1; i <num.length; i++) {
            if(!bool[i]){
                bool[i]=true;
                sum+=num[i];
                list.add(i);
                f(a+1,list);
                bool[i]=false;
                sum-=num[i];
                list.remove(a);
            }
        }


    }

}