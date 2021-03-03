package demo02;

import java.util.ArrayList;
import java.util.Random;

public class Member extends User {
    public Member() {
    }

    //constructor extended from User
    public Member(String name, int money) {
        super(name, money);
    }

    //The members can receive money
    public void receive(ArrayList<Integer> list) {
        int index = new Random().nextInt(list.size());
        int delta = list.remove(index);
        int money = super.getMoney();
        super.setMoney(money + delta);

    }
}
