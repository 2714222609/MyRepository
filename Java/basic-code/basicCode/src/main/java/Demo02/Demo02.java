package Demo02;

import java.util.ArrayList;
import java.util.Random;

public class Demo02 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random r = new Random();
        for (int i = 0; i < 6; i++) {
            list.add(r.nextInt(33) + 1);
        }
        for (Integer i : list) {
            System.out.println(i);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
