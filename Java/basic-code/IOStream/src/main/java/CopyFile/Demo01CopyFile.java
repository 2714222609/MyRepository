package CopyFile;
/**
 * 文件复制的练习
 * 明确：
 * 数据源和数据目的地
 * 步骤：
 * 1.创建字节输入流，构造方法中写入要读取的数据源。
 * 2.创建字节输出流，构造方法中写入目的地。
 * 3.使用read读取字节。
 * 4.使用write写入字节。
 * 5.释放资源。
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo01CopyFile {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\1.jpg");
        FileOutputStream fos = new FileOutputStream("D:\\1.jpg");
//        int len = 0;
//        while((len = fis.read()) != -1){
//            fos.write(len);
//        }
//
        //使用数组缓冲读取多个字节，写入多个字节,可缩短时间；
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read()) != -1) {
            fos.write(bytes, 0, len);
        }
        fos.close();
        fis.close();
    }
}
