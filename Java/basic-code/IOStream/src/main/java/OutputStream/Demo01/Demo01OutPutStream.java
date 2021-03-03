package OutputStream.Demo01;
/*
 * java.io.OutputStream:字节输出流，此抽象类表示所有输出字节流类的超类
 * 定义了一些子类共性的成员方法：
 *     - public void close（） 关闭此输出流并释放与此类相关联的任何系统资源
 *     - public void flush（） 刷新此输出流并强制任何缓冲的输出字节被写出
 *     - public void write（byte【】 b） 将b.length字节从指定的字节数组写入此输出流
 *     - public void write（byte【】 b， int off， int len） 从off开始写len长度的字节
 *     - public abstract void write（int b） 将指定的字节输出流
 *
 * java.io.FileOutputStream extends OutputStream:文件字节输出流，把内存中的数据写入到硬盘的文件中。
 * 构造方法：
 *     FileOutputStream（String name）创建指定文件路径的输出文件流
 *     FileOutputStream（File file）创建指定文件的输出文件流
 * 构造方法的作用：
 *     1.创建一个FileOutputStream对象
 *     2.会根据构造方法中传递的文件/文件路径，创建一个空的文件
 *     3.会把FileOutputStream对象指向创建好的文件
 *
 * 向文件中写入数据的原理：（内盘-->硬盘）
 *     java程序-->JVM-->os-->os调用写数据的方法-->把数据写入到文件中
 * */


import java.io.FileOutputStream;
import java.io.IOException;

public class Demo01OutPutStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("C:\\Users\\27142\\Desktop\\编程之路\\Java\\Java_black_horse\\IdeaProjects\\basic-code\\IOStream\\src\\test\\java\\a.txt");
        fos.write(97);
        fos.close();
    }
}
