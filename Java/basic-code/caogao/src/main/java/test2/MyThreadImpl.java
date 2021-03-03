package test2;

public class MyThreadImpl implements Runnable {
    public static void main(String[] args) {
        Thread a = new Thread(new MyThreadImpl());
        a.start();
    }

    public void run() {
        System.out.println("The is the new thread");
    }
}
