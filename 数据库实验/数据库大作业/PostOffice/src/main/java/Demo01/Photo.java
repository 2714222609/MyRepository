package Demo01;

import java.io.*;
import javax.swing.*;

public class Photo
{
    public void display() throws Exception {
        //源文件
        File sf = new File("C:\\Users\\27142\\Desktop\\PostOffice\\src\\main\\webapp\\支付二维码.jpg");

        //目的文件
        File df = new File("C:\\Users\\27142\\Desktop\\PostOffice\\src\\main\\webapp\\复制品.jpg");
        new ReadWriteGra(sf,df);
        new UseGra(df);
    }
}

class ReadWriteGra
{
    FileInputStream in = null;
    FileOutputStream out = null;
    public ReadWriteGra(File sourceFile,File destFile) throws Exception{
        byte[] buf = new byte[1024];
        int len = 0;
        in = new FileInputStream(sourceFile);
        out = new FileOutputStream(destFile,true);
        while( (len = in.read(buf)) != -1 ){
            out.write(buf,0,len);
        }
        out.close();
    }
}
class UseGra extends JFrame {
    public UseGra(File picFile) throws Exception {

        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(null);
        this.setBounds(500, 100, 700, 500);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel p1 = (JPanel) this.getContentPane();
        p1.setOpaque(false);
        p1.setLayout(null);
        InputStream is = new FileInputStream(picFile);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int b = 0;
        while ((b = is.read()) != -1) {
            baos.write(b);
        }
        ImageIcon image = new ImageIcon(baos.toByteArray());
        JLabel background = new JLabel(image);
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
        validate();
    }
}
