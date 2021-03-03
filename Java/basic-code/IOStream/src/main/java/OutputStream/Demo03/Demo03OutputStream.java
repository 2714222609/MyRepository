package OutputStream.Demo03;

import java.io.FileOutputStream;
import java.io.IOException;

/*数据的追加写和续写：
    FileOutputStream(String name, boolean append)；
    FileOutputStream(File file, boolean append);
    boolean append: 追加写开关，当为true时对象不会覆盖源文件，继续在文件的末尾追加写数据
    当为false时创建一个新文件，覆盖原文件。
  换行符：
    windows:\r\n
    linux:/n
    moc:\r
* */
public class Demo03OutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("C:\\Users\\27142\\Desktop\\编程之路\\Java\\Java_black_horse\\IdeaProjects\\basic-code\\IOStream\\src\\test\\java\\c.txt", true);

        for (int i = 0; i < 10; i++) {
            fos.write("你好".getBytes());
            fos.write("\r\n".getBytes());
        }
        fos.close();
    }
}
