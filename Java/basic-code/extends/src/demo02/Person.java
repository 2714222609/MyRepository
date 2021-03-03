package demo02;

/*Inheritance in Java has the following characteristics:
 * 1.Java language is single inheritance, a class has only
 * one parent class.
 * 2.Java language can inherit at multiple levels.
 * 3.A class has only one parent, but is can has many brothers.*/
public class Person {
    public static void main(String[] args) {
        Father father = new Father(54, "Bob", "Engineer");
        System.out.println(father.getName() + "  " + father.getAge() + "  " + father.getWork());
        father.show();
    }


}
