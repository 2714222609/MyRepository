package Demo01;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
    订单查询页面,
    实现订单查询功能
 */

public class OrdersQuery {
    public static void execute() throws SQLException, IOException {
        String i = "1";
        while(Integer.parseInt(i)>0){
            System.out.println("***********************************订单查询页面*******************************************");
            System.out.println("订单号\t\t收报人ID\t\t报纸编号\t\t订购数量\t\t\t总价\t\t\t\t下单日期");
            Statement stmt = ConnectSql.connect();
            ResultSet rs1 = stmt.executeQuery("select oid,cid,nid,oqty,oprice,odate from OD");
            while (rs1.next()) {
                System.out.println(rs1.getString(1) + "\t" + rs1.getString(2)
                        + "\t" + rs1.getString(3) + "\t" + rs1.getInt(4)
                        + "\t\t\t\t" + rs1.getFloat(5) + "\t\t\t" +rs1.getString(6));
            }
            System.out.println("***********************************订单查询界面*******************************************");
            System.out.println("---------------------------------");
            System.out.println("        请输入你的查询方式");
            System.out.println("---------------------------------");
            System.out.println("1.按订单号查询        2.按客户编号查询");
            System.out.println("3.返回上一页面");
            System.out.println("---------------------------------");
            Scanner scan = new Scanner(System.in);
            String select_1 = scan.nextLine();
            switch (select_1){
                case "1":{
                    System.out.print("请输入订单号：");
                    String orderid = scan.nextLine();
                    String sql = "'"+orderid+"'";
                    ResultSet rs = stmt.executeQuery("select OD.oid,OD.cid,CT.cname,OD.nid,OD.oqty,OD.oprice,OD.odate,CT.ctel,CT.cadrs,CT.cposid from OD,CT where OD.oid="+sql+" and OD.cid=CT.cid");
                    if(rs.isBeforeFirst()) {
                        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("订单号\t\t收报人ID\t\t收报人姓名\t\t报纸编号\t\t订购数量\t\t\t总价\t\t\t\t下单日期\t\t\t\t\t\t电话\t\t\t地址\t\t\t邮编");
                        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
                        while (rs.next()) {
                            System.out.println(rs.getString(1) + "\t" + rs.getString(2)
                                    + "\t" + rs.getString(3) + "\t" + rs.getString(4)
                                    + "\t" + rs.getInt(5) + "\t\t\t\t" +rs.getFloat(6)
                                    + "\t\t\t" + rs.getString(7) + "\t\t" + rs.getString(8)
                                    + "\t" + rs.getString(9).replace(" ","") + "\t\t" + rs.getString(10));
                        }
                    }
                    else{
                        System.out.println("查询失败,订单号不存在！");
                    }
                    break;
                }
                case "2":{
                    System.out.print("请输入客户编号：");
                    String customerid = scan.nextLine();
                    String sql = "'"+customerid+"'";
                    ResultSet rs = stmt.executeQuery("select OD.oid,OD.cid,CT.cname,OD.nid,OD.oqty,OD.oprice,OD.odate,CT.ctel,CT.cadrs,CT.cposid from OD,CT where OD.cid="+sql+" and OD.cid=CT.cid");
                    if(rs.isBeforeFirst()) {
                        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("订单号\t\t收报人ID\t\t收报人姓名\t\t报纸编号\t\t订购数量\t\t\t总价\t\t\t\t下单日期\t\t\t\t\t\t电话\t\t\t地址\t\t\t邮编");
                        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
                        while (rs.next()) {
                            System.out.println(rs.getString(1) + "\t" + rs.getString(2)
                                    + "\t" + rs.getString(3) + "\t" + rs.getString(4)
                                    + "\t" + rs.getInt(5) + "\t\t\t\t" +rs.getFloat(6)
                                    + "\t\t\t" + rs.getString(7) + "\t\t" + rs.getString(8)
                                    + "\t" + rs.getString(9).replace(" ","") + "\t\t" + rs.getString(10));
                        }
                    }
                    else{
                        System.out.println("查询失败,客户编号不存在！");
                    }
                    break;
                }
                case "3":{
                    i = "0";
                    System.out.println("返回成功!");
                    break;
                }
                default:{
                    i = "0";
                    System.out.println("指令有误，请重新输入！");
                    break;
                }
            }
            System.in.read();
        }
    }
}
