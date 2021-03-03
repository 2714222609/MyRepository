package Demo03;

import java.awt.Graphics;
import java.awt.Image;

public class Applet9 extends java.applet.Applet {
    Image img;

    public void init() {
        img = getImage(getCodeBase(), "C:\\Users\\27142\\Desktop\\程序\\Java\\实验课\\Experiment3\\src\\test\\java\\Demo03\\test.gif");
    }

    public void paint(Graphics g) {
        int w = img.getWidth(this);
        int h = img.getHeight(this);
        g.drawImage(img, 20, 10, this); //原图
        g.drawImage(img, 200, 10, w / 2, h / 2, this); //缩小一半
        g.drawImage(img, 20, 200, w * 2, h / 3, this); //宽扁图
        g.drawImage(img, 350, 10, w / 2, h * 2, this); //瘦高图
    }
}