package Demo01;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/*
    购物页面,
    实现报纸订购和购物车管理功能
 */

public class Shopping {
    public String userid;
    public String username;

    public Shopping(String userid, String username) {
        this.userid = userid;
        this.username = username;
    }

    public void look() throws Exception {
        Scanner scan = new Scanner(System.in);
        String i = "1";
        while (Integer.parseInt(i) > 0) {
            System.out.println("欢迎进入报纸订购页面......");
            System.out.println("我们有以下报纸,供您选择...");
            System.out.println("*****************************购物页面***************************");
            Statement stmt = ConnectSql.connect();
            ResultSet rs = stmt.executeQuery("select nid,nname,ncfct,nprice from NP");
            while (rs.next()) {
                System.out.println(rs.getString(1) + "\t" + rs.getString(2)
                        + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "元");
            }
            System.out.println("*****************************购物页面***************************");
            System.out.println("---------------------------------");
            System.out.println("        请选择您的操作");
            System.out.println("---------------------------------");
            System.out.println("1.购买报纸        2.查看购物车");
            System.out.println("3.返回上一页面");
            System.out.println("---------------------------------");
            System.out.print("请输入您的选择: ");
            String select_1 = scan.nextLine();
            switch (select_1) {
                case "1": {
                    String j = "1";
                    while (Integer.parseInt(j) > 0) {
                        System.out.print("请输入报纸编号:");
                        String select_2 = scan.nextLine();
                        String sql_1 = "'" + select_2 + "'";
                        ResultSet rs_2 = stmt.executeQuery("select * from SC where cid='"+this.userid+"' and nid="+sql_1);
                        if(rs_2.isBeforeFirst()){
                            System.out.println("该报纸之前已放入购物车!");
//                            System.in.read();
                            j = "0";
                        }
                        else {
                            ResultSet rs_1 = stmt.executeQuery("select * from NP where nid=" + sql_1);
                            if (rs_1.isBeforeFirst()) {
                                System.out.print("请输入订购数量：");
                                String select_3 = scan.nextLine();
                                String s2 = "";
                                Float float1 = 1.2f;
                                while (rs_1.next()) {
                                    float1 = rs_1.getFloat(3);
                                    s2 = rs_1.getString(2);
                                }
                                float cost_1 = float1 * Integer.parseInt(select_3);
                                System.out.println();
                                System.out.println("《" + s2.replace(" ", "") + "》 " + select_3 + " 份," + " 总价为 " + cost_1 + " 元");
                                System.out.println("是否加入购物车?");
                                System.out.println("---------------------------------");
                                System.out.println("1.加入购物车        2.我再看看");
                                System.out.println("---------------------------------");
                                String select_4 = scan.nextLine();
                                if (select_4.equals("1")) {
                                    String nid = "'" + select_2 + "'";
                                    String cid = "'" + this.userid + "'";
                                    String cname = "'" + this.username + "'";
                                    Calendar calendar = Calendar.getInstance();
                                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                                    String odate = "'" + formatter.format(calendar.getTime()) + "'";
                                    stmt.execute("insert into SC values(" + nid + "," + cid + "," + cname + "," + odate + "," + select_3 + "," + cost_1 + ")");
                                    System.out.println("添加购物车成功!");
                                } else {
                                    System.out.println("已取消!");
                                }
                                //System.in.read();
                                j = "0";
                            } else {
                                System.out.println("报纸编号不存在！");
                                System.out.println("是否重新输入？");
                                System.out.println("---------------------------------");
                                System.out.println("1.重新输入         2.返回购物页面");
                                System.out.println("---------------------------------");
                                String select_3 = scan.nextLine();
                                if (select_3.equals("1")) {
                                    String s2 = scan.nextLine();
                                    j = "1";
                                } else j = "0";
                            }
                        }
                    }
                    break;
                }
                case "2": {
                    String i1 = "1";
                    while (Integer.parseInt(i1) > 0) {
                        System.out.println("*******************************************购物车*********************************************");
                        ResultSet rs_1 = stmt.executeQuery("select SC.nid,NP.nname,NP.nprice,SC.oqty,SC.oprice,SC.odate from SC,NP where cid=" + "'" + this.userid + "'" + " and SC.nid=NP.nid");
                        System.out.println("报纸编号\t\t\t报纸名称\t\t\t报纸单价\t\t\t数量\t\t\t总花费\t\t\t\t添加日期");
                        while (rs_1.next()) {
                            System.out.println(rs_1.getString(1) + "\t" + rs_1.getString(2) + "\t"
                                    + rs_1.getString(3) + "元\t\t\t" + rs_1.getString(4) + "份\t\t"
                                    + rs_1.getString(5) + "元\t\t\t" + rs_1.getString(6));
                        }
                        System.out.println("*******************************************购物车*********************************************");
                        System.out.println("---------------------------------");
                        System.out.println("           请选择您的操作  ");
                        System.out.println("1.生成订单         2.修改购物信息");
                        System.out.println("3.删除购物信息      4.返回购物界面");
                        System.out.println("---------------------------------");
                        String select_2 = scan.nextLine();
                        switch (select_2) {
                            case "1": {
                                System.out.println("           请确认是否生成订单 ");
                                System.out.println("---------------------------------");
                                System.out.println("1.确认         2.取消");
                                System.out.println("---------------------------------");
                                new Photo().display();
                                String select_3 = scan.nextLine();
                                if(select_3.equals("1")){
                                    ResultSet rs_2 = stmt.executeQuery("select * from OD");
                                    int row = 1;
                                    if(rs_2.isBeforeFirst()) {
                                        while (rs_2.next()) {
                                            row++;
                                        }
                                    }
                                    String i2 = "1";
                                    while(Integer.parseInt(i2)>0) {
                                        ResultSet rs_3 = stmt.executeQuery("select * from SC where cid='"+this.userid+"'");
                                        if(rs_3.isBeforeFirst()) {
                                            if(rs_3.next()) {
                                                String s3 = rs_3.getString(1);
                                                stmt.execute("insert into OD values('" + "" + row + "','" + s3 + "','" + rs_3.getString(2) + "','" + rs_3.getString(4) + "'," + rs_3.getInt(5) + "," + rs_3.getFloat(6) + ")");
                                                row++;
                                                stmt.execute("delete from SC where cid='" + this.userid + "' and nid='" + s3 + "'");
                                            }
                                        }
                                        else {
                                            i2 = "0";
                                        }
                                    }
                                    System.out.println("订单已成功生成,请您注意您的物流信息!");
                                }
                                else {
                                    System.out.println("订单未生成!");
                                }
                                //System.in.read();
                                break;
                            }
                            case "2": {
                                String k = "1";
                                while (Integer.parseInt(k) > 0) {
                                    float f_1 = 1.2f;
                                    String name = "";
                                    System.out.print("请输入您要修改的报纸编号:");
                                    String select_3 = scan.nextLine();
                                    System.out.print("请输入您要订购的报纸数量:");
                                    String select_4 = scan.nextLine();
                                    ResultSet rs_2 = stmt.executeQuery("select NP.nprice,NP.nname from SC,NP where cid=" + "'" + this.userid + "'" + " and SC.nid=NP.nid and SC.nid=" + "'" + select_3 + "'");
                                    if (rs_2.isBeforeFirst()) {
                                        while (rs_2.next()) {
                                            f_1 = rs_2.getFloat(1);
                                            name = rs_2.getString(2);
                                        }
                                        System.out.println("《" + name.replace(" ", "") + "》 " + select_4 + " 份," + " 总价为 " + Integer.parseInt(select_4) * f_1 + " 元");
                                        System.out.println("---------------------------------");
                                        System.out.println("            请确认是否修改 ");
                                        System.out.println("---------------------------------");
                                        System.out.println("1.确认         2.取消");
                                        System.out.println("---------------------------------");
                                        String select_5 = scan.nextLine();
                                        if (select_5.equals("1")) {
                                            stmt.execute("update SC set oqty=" + select_4 + ",oprice=" + Integer.parseInt(select_4) * f_1 + " where cid=" + "'" + this.userid + "'" + "and nid=" + "'" + select_3 + "'");
                                            System.out.println("修改购物车信息成功!");
                                        }
                                        else {
                                            System.out.println("已取消!");
                                        }
                                        //System.in.read();
                                        k = "0";
                                    } else {
                                        System.out.println();
                                        System.out.println("购物车中该报纸编号不存在!");
                                        System.out.println("是否重新输入?");
                                        System.out.println("---------------------------------");
                                        System.out.println("1，重新输入         2.返回购物车");
                                        System.out.println("---------------------------------");
                                        String select_5 = scan.nextLine();
                                        if (select_5 == "1") {
                                            k = "1";
                                        } else {
                                            k = "0";
                                        }
                                    }
                                }
                                break;
                            }
                            case "3": {
                                String i2 = "1";
                                while(Integer.parseInt(i2)>0){
                                    System.out.println("*****************************************购物车***********************************************");
                                    ResultSet rs_3 = stmt.executeQuery("select SC.nid,NP.nname,NP.nprice,SC.oqty,SC.oprice,SC.odate from SC,NP where cid=" + "'" + this.userid + "'" + " and SC.nid=NP.nid");
                                    System.out.println("报纸编号\t\t报纸名称\t\t\t\t报纸单价\t\t\t数量\t\t\t\t总花费\t\t\t\t添加日期");
                                    while (rs_3.next()) {
                                        System.out.println(rs_3.getString(1) + "\t" + rs_3.getString(2) + "\t"
                                                + rs_3.getString(3) + "元\t\t\t" + rs_3.getString(4) + "份\t\t\t"
                                                + rs_3.getString(5) + "元\t\t\t" + rs_3.getString(6));
                                    }
                                    System.out.println("*****************************************购物车***********************************************");
                                    System.out.println("            请选择您的操作 ");
                                    System.out.println("---------------------------------");
                                    System.out.println("1.不想要某些报纸了         2.清空购物车");
                                    System.out.println("3.返回购物车");
                                    System.out.println("---------------------------------");
                                    String select_3 = scan.nextLine();
                                    switch (select_3){
                                        case "1":{
                                            String k = "1";
                                            while(Integer.parseInt(k)>0) {
                                                String name = "";
                                                int count = 0;
                                                float cost = 1.2f;
                                                String date = "";
                                                System.out.print("请输入不想要的报纸编号:");
                                                String select_4 = scan.nextLine();
                                                ResultSet rs_2 = stmt.executeQuery("select NP.nname,SC.oqty,SC.oprice,SC.odate from SC,NP where cid=" + "'" + this.userid + "'" + " and SC.nid=NP.nid and SC.nid=" + "'" + select_4 + "'");
                                                if (rs_2.isBeforeFirst()) {
                                                    while (rs_2.next()) {
                                                        name = rs_2.getString(1);
                                                        count = rs_2.getInt(2);
                                                        cost = rs_2.getFloat(3);
                                                        date = rs_2.getString(4);
                                                    }
                                                    System.out.println("请确认是否取消 "+name.replace(" ","")+" "+count+"份 "+cost+"元 "+date+" 订单");
                                                    System.out.println("---------------------------------");
                                                    System.out.println("1.确认取消该订单         2.再想想");
                                                    System.out.println("---------------------------------");
                                                    String select_5 = scan.nextLine();
                                                    if (select_5 == "1") {
                                                        stmt.execute("delete from SC where cid=" + "'" + this.userid + "'" + " and nid=" + "'" + select_4 + "'");
                                                        System.out.println("订单已取消!");
                                                        i2 = "0";
                                                    }
                                                    else {
                                                        System.out.println("订单未取消!");
                                                    }
                                                    //System.in.read();
                                                    k = "0";
                                                } else {
                                                    System.out.println();
                                                    System.out.println("购物车中该报纸编号不存在!");
                                                    System.out.println("是否重新输入?");
                                                    System.out.println("---------------------------------");
                                                    System.out.println("1.重新输入        2.返回上一页");
                                                    System.out.println("---------------------------------");
                                                    String select_5 = scan.nextLine();
                                                    if (select_5.equals("1")) {
                                                        k = "1";
                                                    } else {
                                                        k = "0";
                                                    }
                                                }
                                            }
                                            break;
                                        }
                                        case "2":{
                                            System.out.println("请确认是否清空购物车");
                                            System.out.println("---------------------------------");
                                            System.out.println("1.确认清空购物车         2.再想想");
                                            System.out.println("---------------------------------");
                                            String select_5 = scan.nextLine();
                                            if (select_5.equals("1")) {
                                                stmt.execute("delete from SC where cid=" + "'" + this.userid + "'");
                                                System.out.println("购物车已清空!");
                                                i2 = "0";
                                            }
                                            else {
                                                System.out.println("购物车清空操作取消!");
                                            }
                                            //System.in.read();
                                            break;
                                        }
                                        case "3":{
                                            i2 = "0";
                                            break;
                                        }
                                    }
                                }
                                break;
                            }
                            case "4":{
                                i1 = "0";
                                break;
                            }
                        }
                    }
                    break;
                }
                case "3":{
                    i="0";
                    System.out.println("返回成功!");
                    //System.in.read();
                    break;
                }
            }
            stmt.close();
        }
    }
}
