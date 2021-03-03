package demo01;

public class DemoMain {
    public static void main(String[] args) {
        //Wrong way of writing:Animal animal = new Animal();
        Cat cat = new Cat();
        cat.eat();
        Dog dog = new Dog();
        dog.eat();
    }
}
