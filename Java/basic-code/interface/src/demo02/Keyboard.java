package demo02;

public class Keyboard implements USB {
    @Override
    public void open() {
        System.out.println("The keyboard is open.");
    }

    @Override
    public void close() {
        System.out.println("The keyboard is close.");
    }
}
