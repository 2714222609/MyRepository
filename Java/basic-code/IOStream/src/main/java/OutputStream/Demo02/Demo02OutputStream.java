package OutputStream.Demo02;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/*一次写入多个字节的方法：
 *     - public void write(byte[] b) 将b.length字节从指定的字节数组写入此输出流
 *     - public void write(byte[] b, int off , int len) 从指定的字节数组off开始写入长度为len的字节
 * */
public class Demo02OutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\27142\\Desktop\\编程之路\\Java\\Java_black_horse\\IdeaProjects\\basic-code\\IOStream\\src\\test\\java\\b.txt"));
        byte[] bytes = {49, 48, 48};
        fos.write(bytes);

        byte[] bytes1 = {65, 66, 67, 68, 69};
        fos.write(bytes1, 1, 3);

        //写入字符串的方法：可以使用String类中的方法byte[] getBytes()把字符串转换为字节数组,然后写入。
        byte[] bytes2 = "Hello world, hello java!".getBytes();
        fos.write("\n".getBytes());
        fos.write(bytes2);
        fos.close();
    }
}
