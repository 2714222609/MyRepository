package demo02;

import java.util.ArrayList;

//The main class
public class User {
    //member properties includes name and money
    private String name;
    private int money;

    //constructor without param
    public User() {
    }

    //constructor with param
    public User(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    //show the properties
    public void show() {
        System.out.println("I'm the " + name + ", and my total money is " + money);
    }

}
