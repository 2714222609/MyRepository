package Demo04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("basicCode\\src\\main\\java\\Demo04\\2.jpg");
        FileOutputStream fos = new FileOutputStream("basicCode\\src\\main\\java\\Demo04\\copy.jpg");

//        int len = 0;
//        while((len = fis.read()) != -1){
//            fos.write(len);
//        }

        byte[] bytes = new byte[1024];
        int len = 0;
        while((len = fis.read(bytes)) != -1){
            fos.write(bytes,0,len);
        }
        fos.close();
        fis.close();
    }
}
