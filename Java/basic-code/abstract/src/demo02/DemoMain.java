package demo02;

import java.util.ArrayList;

public class DemoMain {
    public static void main(String[] args) {
        //the boss
        Boss boss = new Boss("Boss", 200);
        //three members
        Member one = new Member("memberOne", 0);
        Member two = new Member("memberTwo", 0);
        Member three = new Member("memberThree", 0);
        //Before handing out, their money
        boss.show();
        one.show();
        two.show();
        three.show();
        System.out.println("===========================================");
        //After handing out,their money
        System.out.println("After handing out red envelops:");
        ArrayList<Integer> redList = boss.send(70, 3);
        one.receive(redList);
        two.receive(redList);
        three.receive(redList);

        boss.show();
        one.show();
        two.show();
        three.show();

    }
}
