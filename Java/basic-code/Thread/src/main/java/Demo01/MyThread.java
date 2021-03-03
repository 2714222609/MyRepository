package Demo01;

public class MyThread extends Thread {
    //重写thread类中的run方法，设置线程任务
    @Override
    public void run() {
        /*获取线程名称1
        String name = getName();
        System.out.println(name);
         */

        //获取线程名称2(链式编程)
        System.out.println(Thread.currentThread().getName());
    }
}
