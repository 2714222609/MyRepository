package test2;

public class MyThread extends Thread {

    public static void main(String[] args) {
        Thread a = new MyThread();
        a.start();

        System.out.println("This the main Thread");
    }

    @Override
    public void run() {
        System.out.println("This is the thread a");
    }

}

