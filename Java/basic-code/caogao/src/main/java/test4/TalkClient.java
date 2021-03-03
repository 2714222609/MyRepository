package test4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TalkClient {

    public static void main(String[] args) {
        try {
            //向本机的4700端口发送客户请求，创建一个socket对象
            Socket socket = new Socket("127.0.0.1", 4700);
            //由系统标准输入设备构造BufferedReader对象，可以将键盘输入的数据读取到程序中
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            //由Socket对象得到输出流，并构造PrintWriter对象，可以将数据保存在Socket之中
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            //由Socket对象得到输入流，并构造相应的BufferedReader对象，可以将保存在Socket之中的数据输入到程序中
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String readline;
            //由键盘输入数据
            readline = sin.readLine();
            while (!readline.equals("bye")) {
                //使用输出流将数据打印到socket之中
                os.println(readline);
                os.flush();
                //在输出框中显示
                System.out.println("Client:" + readline);
                //从socket获取服务端发送的消息
                System.out.println("Server:" + is.readLine());
                readline = sin.readLine();
            }
            os.close();
            is.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
    }
}
