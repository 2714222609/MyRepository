package Client;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
* 客户端
* */

public class WindowClient extends JFrame implements ActionListener,Runnable {
    //客户端，继承JFrame容器，显示GUI界面
    JButton connect, say,message;
    JTextField inputTextIp, inputTextPort, inputTextSay;
    JTextArea show;
    Socket socket;
    DataInputStream in = null;
    DataOutputStream out = null;
    Thread thread;

    WindowClient() {
        //创建Socket，将GUI组件添加到容器中
        socket = new Socket();
        connect = new JButton("建立连接");
        say = new JButton("发送");
        message = new JButton("聊天记录");
        message.setEnabled(true);
        say.setEnabled(true);
        inputTextIp = new JTextField(15);
        inputTextPort = new JTextField(15);
        inputTextSay = new JTextField(30);
        show = new JTextArea();
        show.setEditable(false);

        //北部组件
        JPanel pNorth = new JPanel();
        pNorth.setBorder(BorderFactory.createTitledBorder("客户机设置: "));
        pNorth.add(new JLabel("服务端IP:"));
        pNorth.add(inputTextIp);
        pNorth.add(new JLabel("服务端口号:"));
        pNorth.add(inputTextPort);
        pNorth.add(connect);

        //南部组件
        JPanel pSouth = new JPanel();
        pSouth.add(new JLabel("发送内容:"));
        pSouth.add(inputTextSay);
        pSouth.add(say);
        pSouth.add(message);

        //将组件添加到容器中
        add(pNorth, BorderLayout.NORTH);
        add(new JScrollPane(show), BorderLayout.CENTER);
        add(pSouth, BorderLayout.SOUTH);

        //监听鼠标事件
        connect.addActionListener(this);
        say.addActionListener(this);
        message.addActionListener(this);
        thread = new Thread(this);
        setBounds(100, 500, 600, 400);
        setVisible(true);
        setTitle("客户端");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==connect) {
            try {
                if(!socket.isConnected()) {
                    show.append("已连接到服务端.....\n");
                    InetAddress address=InetAddress.getByName(inputTextIp.getText());
                    InetSocketAddress socketAddress=new InetSocketAddress(address,Integer.parseInt(inputTextPort.getText()));
                    socket.connect(socketAddress);
                    in=new DataInputStream(socket.getInputStream());
                    out=new DataOutputStream(socket.getOutputStream());
                    if(!thread.isAlive())
                        thread=new Thread(this);
                    thread.start();
                }
            }
            catch(IOException ee) {
                // System.out.println(ee);
                ee.printStackTrace();
                socket=new Socket();
            }
        }
        if(e.getSource()==say) {
            String s_out=inputTextSay.getText();
            show.append("我说："+s_out+"\n");
            try{
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                FileWriter fileWriter = new FileWriter("message.txt",true);
                fileWriter.write("["+simpleDateFormat.format(date)+"]"+"客户端："+s_out+"\r\n");
                fileWriter.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            try {
                out.writeUTF(s_out);
            }
            catch(IOException e1) {e1.printStackTrace();}
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
        //服务端线程，可检测服务器是否关闭
        while(true) {
            try {
                s_in=in.readUTF();
                show.append("服务器："+s_in+"\n");
                System.out.println();
            }
            catch(IOException e) {
                show.setText("与服务器断开"+e);
                socket=new Socket();
                break;
            }
        }
    }
}
