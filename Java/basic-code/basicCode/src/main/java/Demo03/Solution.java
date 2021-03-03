package Demo03;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*输入一个字符串，统计每个字符出现个次数，如输入aaabbfee，输出a=3，b=2，f=1，ee=2*/
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c,1);
            }else{
                 int value = map.get(c);
                 value++;
                 map.put(c,value);
            }
        }
        for(Character key : map.keySet()){
            Integer value = map.get(key);
            System.out.println(key+"="+value);
        }
    }
}
