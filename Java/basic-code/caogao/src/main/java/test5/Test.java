package test5;

import java.io.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
//        //将从键盘输入的数据输入到程序中
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String s = bufferedReader.readLine();
//        System.out.println(s);
//
//        Scanner scanner = new Scanner(System.in);
//        String s1 = scanner.nextLine();
//        System.out.println(s1);

//        //PrintWriter可以将数据打印到指定的文件中，如果没有开启自动刷新，则需要用flush刷新。
//        PrintWriter pw = new PrintWriter(new FileOutputStream("d:\\test.txt"));
//        pw.println("字符串");
//        pw.flush();
//

//        //使用BufferedReader读取txt文件中的内容
//        BufferedReader br = new BufferedReader(new FileReader("d:\\test.txt"));
//        String s;
//        StringBuffer sb = new StringBuffer();
//        while((s=br.readLine()) != null){
//            sb.append(s);
//            sb.append("\n");
//        }
//        br.close();
//        System.out.println(sb);

        //使用BufferedWriter向txt文件中写入数据
        BufferedWriter bw = new BufferedWriter(new FileWriter("d:\\test.txt", true));
        String s = "汇编语言";
        bw.write(s);
        bw.flush();
        bw.close();

    }
}
