package demo02;

import java.util.ArrayList;

//The boss class handing out red packet, extends from User;
public class Boss extends User {
    public Boss() {
    }

    //constructor extended from User
    public Boss(String name, int money) {
        super(name, money);
    }

    //The money is divided into several parts, storing in ArrayList;
    public ArrayList<Integer> send(int sendMoney, int count) {
        ArrayList<Integer> redList = new ArrayList<>();
        int totalMoney = super.getMoney();
        //If the sent money > total money
        if (sendMoney > totalMoney) {
            System.out.println("Sorry, your credit is running low.");
            return redList;
        }
        //After handing, the money left
        super.setMoney(totalMoney - sendMoney);
        int avg = sendMoney / count;
        int mod = sendMoney % count;
        //Add each part to the Arraylist
        for (int i = 0; i < count - 1; i++) {
            redList.add(avg);
        }
        //If it's not divisible, store the left money in last list
        int last = avg + mod;
        redList.add(last);
        return redList;

    }
}
