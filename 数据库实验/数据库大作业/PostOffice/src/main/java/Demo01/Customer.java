package Demo01;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class Customer {
    static String URL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName = PostOffice";
    static String USER;
    static String PW;
    public static void customer() throws Exception {
        //超级管理员
        String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName = PostOffice";
        String user = "superadmin";
        String pw = "superadmin123";
        Connection conn1 = DriverManager.getConnection(url,user,pw);

        String account;
        String password;
        Scanner sc = new Scanner(System.in);
        loop:
        while(true){
            //客户登录
            System.out.print("请输入客户账号:");
            account = sc.nextLine();
            System.out.print("请输入密码:");
            password = sc.nextLine();
            //检验账户和密码是否正确
            Statement statement = conn1.createStatement();
            String sql = "select cid, cpw from CT";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){  //从CT表中获取客户的数据，看是否匹配
                String cid = resultSet.getString("cid");
                String cpw = resultSet.getString("cpw");
                cid = cid.replace(" ","");
                cpw = cpw.replace(" ","");
                if(cid.equals(account) && cpw.equals(password) ) {
                    conn1.close();
                    System.out.println("---------------------------------");
                    System.out.println("登录成功！");
                    System.out.println("---------------------------------");
                    break loop;
                }
            }
            System.out.println("---------------------------------");
            System.out.println("用户名或密码错误，请重新输入。");
            System.out.println("---------------------------------");
        }

        //管理员账户密码正确后，连接到数据库
        USER = account;
        PW = password;
        Connection conn = DriverManager.getConnection(URL,USER,PW);

        int i = 1;
        while(i > 0){
            System.out.println("---------------------------------");
            System.out.println("      客户你好，请选择你的操作");
            System.out.println("---------------------------------");
            System.out.println("1.报纸查询                 2.购买报纸");
            System.out.println("3.订单查询                 4.退出");
            System.out.println("---------------------------------");
            System.out.print("请输入你的选择：");
            Scanner scan = new Scanner(System.in);
            String select_1 = scan.nextLine();
            switch (select_1){
                case "1":{
                    NewspaperQuery.excecte();
                    break;
                }
                case "2":{
                    new Shopping("2020001","蜡笔小新").look();
                    break;
                }
                case "3":{
                    OrdersQuery.execute();
                    break;
                }
                case "4":{
                    i = 0;
                    System.out.println("再会!");
                    break;
                }
                default:
                    break;
            }
        }
    }
}
