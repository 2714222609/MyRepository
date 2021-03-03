package Demo02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyGameFrame extends JFrame {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.red);
        g.drawLine(100, 100, 200, 200);//This method can be called automatically.
        g.drawRect(100, 100, 100, 100);
        g.drawRoundRect(200, 200, 150, 70, 40, 25);
        g.drawOval(100, 200, 100, 100);
        int[] x = {140, 180, 170, 180, 140, 100, 110, 100};
        int[] y = {5, 25, 35, 45, 65, 45, 35, 25};
        Polygon polygon = new Polygon();
        polygon.addPoint(100, 20);
        polygon.addPoint(180, 100);
        polygon.addPoint(20, 100);
        g.drawPolygon(polygon);
        g.setColor(Color.yellow);
        Polygon polygon1 = new Polygon(x, y, 8);
        g.fillPolygon(polygon1);
    }

    public void lanuchFrame() {
        //初始化
        this.setTitle("画图");
        this.setSize(500, 500);
        this.setLocation(300, 300);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        MyGameFrame f = new MyGameFrame();
        f.lanuchFrame();
    }
}
