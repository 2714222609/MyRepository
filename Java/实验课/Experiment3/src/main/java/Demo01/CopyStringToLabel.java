package Demo01;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CopyStringToLabel extends Frame implements ActionListener {
    private final Label label = new Label(); //添加Label组件
    private final TextField output = new TextField(); //添加TextField组件
    private final Button copy = new Button("Copy"); //添加Button组件

    private static class WindowCloser extends WindowAdapter {
        public void windowClosing(WindowEvent we) {
            System.exit(0);
        }
    }

    public CopyStringToLabel() {
        super("Copy a String To Label");//设置title
        setup();
        copy.addActionListener(this); //设置监听器
        addWindowListener(new WindowCloser());
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == copy)
            label.setText(output.getText()); //获取输入的内容
    }

    private void setup() {
        Panel textGrid = new Panel();
        textGrid.setLayout(new GridLayout(2, 1));
        textGrid.add(label);
        textGrid.add(output);
        setLayout(new BorderLayout());
        add("Center", textGrid);
        add("South", copy);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        CopyStringToLabel cop = new CopyStringToLabel();
    }
}
