package InputStream.Demo02;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/*
    字节输入流一次读取多个字节的方法：
        int read(byte[] b) 从输入流中读取一定数量的字节，并将其存储在缓冲区数组b中。
        明确两件事情：
            1.方法的参数bytep[]的作用？
                起到缓存作用，存储每次读取到的多个字节。
                数组的长度一般定义为1024（1kb）或者1024的整数倍。
            2.方法的返回值int是什么？
                每次读取的有效字节数。
        String类的构造方法：
            String(byte[] bytes):把字节数组转换为字符串
            String(byte[] bytes, int offset, int length)
* */
public class Demo02InputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\27142\\Desktop\\编程之路\\Java\\Java_black_horse\\IdeaProjects\\basic-code\\IOStream\\src\\test\\java\\b.txt");
        byte[] bytes = new byte[2];
        int len = fis.read(bytes);
        System.out.println(len);
        System.out.println(Arrays.toString(bytes));
        System.out.println(new String(bytes));


        //使用循环读取
        byte[] bytes1 = new byte[1024];
        int len1 = 0;
        while ((len1 = fis.read()) != -1) {
            System.out.println(new String(bytes1, 0, len));
        }
        fis.close();
    }
}
