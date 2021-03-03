package Demo01;

public class Demo01GetThreadName {
    public static void main(String[] args) {
        //创建Thread类的子类对象
        MyThread mt = new MyThread();
        mt.start();

        new MyThread().start();
        new MyThread().start();
        System.out.println(Thread.currentThread().getName());

    }
}
