package test4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TalkServer {
    public static void main(String[] args) {
        try {

            ServerSocket server = null;
            try {
                //创建一个ServerSocket在端口4700监听客户请求
                server = new ServerSocket(4700);
            } catch (Exception e) {
                System.out.println("can not listen to:" + e);
            }
            Socket socket = null;
            try {
                socket = server.accept();
            } catch (Exception e) {
                System.out.println("Error" + e);
            }
            String line;
            //由Socket对象得到输入流，并构造相应的BufferedReader对象，可以从socket获取到内容到程序
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //由Socket对象得到输出流，可以将服务端发送的内容打印到Socket之中。
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            //由系统标准输入设备构造BufferedReader对象，获取服务端从键盘输入的内容
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Client:" + is.readLine());
            line = sin.readLine();
            while (!line.equals("bye")) {
                os.println(line);
                os.flush();
                System.out.println("Server:" + line);
                System.out.println("Client:" + is.readLine());
                line = sin.readLine();
            }
            os.close();
            is.close();
            socket.close();
            server.close();
        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
    }
}
