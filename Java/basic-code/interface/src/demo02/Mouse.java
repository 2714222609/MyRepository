package demo02;

public class Mouse implements USB {

    @Override
    public void open() {
        System.out.println("The mouse is open.");
    }

    @Override
    public void close() {
        System.out.println("The mouse is close.");
    }
}
