package demo01;

public class NewPhone extends Phone {
    @Override
    public void show() {
        super.show();
        System.out.println("Show the name.");
    }
}
