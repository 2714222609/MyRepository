package Demo01;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
    报纸查询页面,
    实现报纸查询功能
 */

public class NewspaperQuery {
    public static void excecte() throws SQLException, IOException {
        String i="0";
        while(Integer.parseInt(i)<=3) {
            System.out.println("\n");
            System.out.println("------------------------------如下报纸可供选择---------------------------");
            System.out.println("报纸编号\t\t报纸名称\t\t\t\t\t报纸种类\t\t\t\t\t\t报纸单价");
            System.out.println("----------------------------------------------------------------------");
            Statement stmt1 = ConnectSql.connect();
            ResultSet rs1 = stmt1.executeQuery("select nid,nname,ncfct,nprice from NP");
            while (rs1.next()) {
                System.out.println(rs1.getString(1) + "\t" + rs1.getString(2)
                        + "\t\t" + rs1.getString(3) + "\t\t\t" + rs1.getString(4) + "元");
            }
            System.out.println("----------------------------------------------------------------------");
            System.out.println("---------------------------------------------");
            System.out.println("1.按报纸名称查询                 2.按报纸分类查询");
            System.out.println("3.按邮发代号查询                 4.返回");
            System.out.println("---------------------------------------------");
            System.out.print("请输入你的查询方式：");
            Scanner scan = new Scanner(System.in);
            i = scan.nextLine();
            System.out.println("---------------------------------------------");
            Statement stmt = ConnectSql.connect();
            if(stmt!=null){
                switch (i){
                    case "1":{
                        System.out.print("请输入待查找报纸名称：");
                        String name = scan.nextLine();
                        String sql = "'"+name+"'";
                        ResultSet rs = stmt.executeQuery("select nid,nname,nprice,ncfct,ncode from NP where nname="+sql);
                        if(rs.isBeforeFirst()) {
                            System.out.println("-----------------------------------------------------------------------------");
                            System.out.println("编号\t\t\t名称\t\t\t\t\t单价\t\t\t\t种类\t\t\t\t\t\t邮发代号");
                            System.out.println("-----------------------------------------------------------------------------");
                            while (rs.next()) {
                                System.out.println(rs.getString(1) + "\t" + rs.getString(2)
                                        + "\t" + rs.getString(3) + "\t\t\t" + rs.getString(4)
                                        + "\t\t" + rs.getString(5));
                            }
                            System.out.println("-----------------------------------------------------------------------------");
                        }
                        else{
                            System.out.println("查询失败,该报纸名不存在！");
                            System.out.println("-----------------------------------------------------------------------------");
                        }
                        break;
                    }
                    case "2":{
                        System.out.print("请输入待查找报纸类别：");
                        String classify = scan.nextLine();
                        System.out.println("------------------------------------------------------------------------------");
                        String sql = "'"+classify+"'";
                        ResultSet rs = stmt.executeQuery("select nid,nname,nprice,ncfct,ncode from NP where ncfct="+sql);
                        if(rs.isBeforeFirst()) {
                            System.out.println("编号\t\t\t名称\t\t\t\t\t单价\t\t\t\t种类\t\t\t\t\t\t邮发代号");
                            System.out.println("------------------------------------------------------------------------------");
                            while (rs.next()) {
                                System.out.println(rs.getString(1) + "\t" + rs.getString(2)
                                        + "\t" + rs.getString(3) + "\t\t\t" + rs.getString(4)
                                        + "\t\t" + rs.getString(5));
                            }
                            System.out.println("------------------------------------------------------------------------------");
                        }
                        else{
                            System.out.println("查询失败,该报纸类别不存在！");
                            System.out.println("---------------------------------------------");
                        }
                        break;
                    }
                    case "3":{
                        System.out.print("请输入待查找报纸邮发代号：");
                        String code = scan.nextLine();
                        System.out.println("------------------------------------------------------------------------------");
                        String sql = "'"+code+"'";
                        ResultSet rs = stmt.executeQuery("select nid,nname,nprice,ncfct,ncode from NP where ncode="+sql);
                        if(rs.isBeforeFirst()) {
                            System.out.println("编号\t\t\t名称\t\t\t\t\t单价\t\t\t\t种类\t\t\t\t\t\t邮发代号");
                            System.out.println("------------------------------------------------------------------------------");
                            while (rs.next()) {
                                System.out.println(rs.getString(1) + "\t" + rs.getString(2)
                                        + "\t" + rs.getString(3) + "\t\t\t" + rs.getString(4)
                                        + "\t\t" + rs.getString(5));
                            }
                            System.out.println("------------------------------------------------------------------------------");
                        }
                        else{
                            System.out.println("查询失败,该报纸类别不存在！");
                            System.out.println("---------------------------------------------");
                        }
                        break;
                    }
                    case "4": {
                        System.out.println("返回成功!");
                        break;
                    }
                    default:
                    {
                        System.out.println("操作非法！请重新输入");
                        i = "0";
                        break;
                    }
                }
            }
            else{
                System.out.println();
                System.out.println("操作失败！数据库连接异常！");
            }
            System.in.read();
        }
    }

}