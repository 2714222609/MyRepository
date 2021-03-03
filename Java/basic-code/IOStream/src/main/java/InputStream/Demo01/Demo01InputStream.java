package InputStream.Demo01;

import java.io.FileInputStream;
import java.io.IOException;

/* java.io.InputStream 字节输入流，此抽象类是所有字节输入流的超类。
    定义所有子类共性方法：
        -int read() 从输入流中读取数据的下一个字节。
        -int read(byte[] b) 从输入流中读取一定数量的字节，并将其存储在缓存区数组b中。
        -void close()关闭

    java.io.FileInputStream extends InputStream
    File InputStream:文件字节输入流
    作用：把硬盘文件中的数据，读取到内存中使用。
    构造方法：
        FileInputStream(String name)
        FileInputStream(File file)
        会创建一个FileInputStream对象，并指定构造方法要读取的文件。
    读取数据的原理(硬盘-->内存)
    java程序-->JVM-->OS-->OS读取数据的方法-->读取文件

    字节输入流的使用步骤：
        1.创建FileInputStream对象，构造方法中绑定要读取的数据源
        2.使用read方法读取文件
        3.释放资源
*/
public class Demo01InputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\27142\\Desktop\\编程之路\\Java\\Java_black_horse\\IdeaProjects\\basic-code\\IOStream\\src\\test\\java\\a.txt");
//        int len = fis.read();//读一个字节
//        System.out.println(len);
//        len = fis.read();//第一次读取后指针将向后移，读取到结尾会返回-1；
//        System.out.println(len);
//        fis.close();

        //使用while循环读取文件中的所有内容
        int len = 0;
        while ((len = fis.read()) != -1) {
            System.out.println((char) len);
            /*1.fis.read()读取一个字节
              2.len = fis.read()读取到的字节赋值给变量len
              3.（len = fis.read() != -1）判断变量len是否不等于-1
            * */
        }
        fis.close();

    }
}
