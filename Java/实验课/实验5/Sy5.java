import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;

public class Sy5 extends JFrame implements Runnable {
    private static final long serialVersionUID = 1L;
    private int x = 0;

    public Sy5() {
        this.setDefaultCloseOperation(3);//设置在点击关闭后自动终止程序
        this.setVisible(true);//可视化
        this.setBounds(50, 150, 500, 500);//设置组件在屏幕中出现的位置和大小
        Thread thread = new Thread(this);
        thread.start();//启动新线程
    }

    public static void main(String[] args) {
        new Sy5();
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(200);//每0.2秒刷新一次
                x = x + 10;//通过改变中心线每次出现的位置来实现旋转
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(4.0f));//设置画笔大小
        g2d.setColor(Color.black);
        g2d.drawOval(100, 100, 300, 300);
        g2d.setColor(Color.blue);
        g2d.fillOval(100, 100, 300, 300);
        g2d.setColor(Color.green);
        g2d.drawArc(100, 250, 300, 20, x, 180);
        g2d.setColor(Color.red);
        g2d.drawArc(100, 250, 300, 20, 180 + x, 180);

    }
}
