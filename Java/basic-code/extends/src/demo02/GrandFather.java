package demo02;

public class GrandFather {
    int num = 1;
    private int age;
    private String name;

    //constructor
    public GrandFather() {
    }

    public GrandFather(int age, String name) {
        this.age = age;
        this.name = name;
    }

    //getter and setter
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println(this.num);
        System.out.println("I'm the grandfather, I like playing basketball.");
    }

}
