package Server;
import javax.naming.Context;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * 服务端
 * */
class WindowServer extends JFrame implements Runnable, ActionListener {
    //定义GUI界面组件，三个JButton，两个JTextField，一个JTextArea
    JButton start, say,message;
    JTextField inputTextPort, inputTextSay;
    JTextArea show;
    Socket socket;

    //输入输出流
    DataOutputStream out = null;
    DataInputStream in = null;
    Thread thread;

    WindowServer() {
        socket = new Socket();
        //服务器开始按钮和发送按钮
        start = new JButton("创建服务器");
        say = new JButton("发送");
        message = new JButton("聊天记录");
        message.setEnabled(true);
        say.setEnabled(true);
        inputTextPort = new JTextField(30);
        inputTextSay = new JTextField(30);
        show = new JTextArea();
        show.setEditable(false);

        //北部组件
        JPanel pNorth = new JPanel();
        pNorth.setBorder(BorderFactory.createTitledBorder("服务器设置: "));
        pNorth.add(new JLabel("端口号:"));
        pNorth.add(inputTextPort);
        pNorth.add(start);

        //南部组件
        JPanel pSouth = new JPanel();
        pSouth.add(new JLabel("发送内容:"));
        pSouth.add(inputTextSay);
        pSouth.add(say);
        pSouth.add(message);

        //将写好的北部和南部界面加入到容器中
        add(pNorth, BorderLayout.NORTH);
        add(new JScrollPane(show), BorderLayout.CENTER);
        add(pSouth, BorderLayout.SOUTH);

        //开始监听鼠标点击事件
        start.addActionListener(this);
        say.addActionListener(this);
        message.addActionListener(this);
        thread = new Thread(this);

        setBounds(10, 10, 600, 400);
        setVisible(true);
        setTitle("服务器");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == start) {
            //当监测到鼠标单击后，服务器开始运行
            show.append("服务器开始运行，等待用户连接中.....\n");
            try {
                if (!socket.isConnected()) {
                    //创建ServeSocket等待客户端的请求，一旦获得一个连接请求，就创建一个Socket示例来与客户端进行通信
                    //获取服务端的端口号，当客户端的端口号正确后，提示成功建立连接
                    ServerSocket serversocket = new ServerSocket(Integer.parseInt(inputTextPort.getText()));
                    socket = serversocket.accept();
                    show.append("客户端已连接.....\n");

                    //获取输入输出流
                    in = new DataInputStream(socket.getInputStream());
                    out = new DataOutputStream(socket.getOutputStream());

                    //客户端线程，检测线程是否已经创建，如果没有创建，则创建
                    if (!thread.isAlive())
                        thread = new Thread(this);
                    thread.start();
                }
            } catch (IOException ee) {
                ee.printStackTrace();
                // System.out.println(ee);
                socket = new Socket();
            }
        }
        if (e.getSource() == say) {
            //监听到鼠标点击后，获取发送的内容，并打印
            String s_out = inputTextSay.getText();
            show.append("我说：" + s_out + "\n");
            try{
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                FileWriter fileWriter = new FileWriter("message.txt",true);
                fileWriter.write("["+simpleDateFormat.format(date)+"]"+"服务端："+s_out+"\r\n");
                fileWriter.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            try {
                out.writeUTF(s_out);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if(e.getSource() == message){
            try {
                Desktop.getDesktop().open(new File("message.txt"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    public void run() {
        String s_in;
        //客户端线程，可检测客户是否离开
        while (true) {
            try {
                s_in = in.readUTF();
                show.append("客户:" + s_in + "\n");
            } catch (IOException e) {
                show.setText("客户已断开连接.....");
                socket = new Socket();
                break;
            }
        }
    }
}
