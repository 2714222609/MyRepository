package Demo01;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
       while(true){
           System.out.println("-------------------------------");
           System.out.println("     欢迎来到邮报管理订阅系统");
           System.out.println("-------------------------------");
           System.out.println("管理员登录请输入1， 客户登录请输入2...");
           System.out.println("-------------------------------");
           String n = new Scanner(System.in).nextLine();
           if(n.equals("1")){
               Admin.admin();
           }
           if(n.equals("2")){
               Customer.customer();
           }
           else{
               System.out.println("输入有误，请重新输入！");
           }
       }
    }
}
