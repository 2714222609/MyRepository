package Demo01;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

class Admin {
    static String URL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName = PostOffice";
    static String USER;
    static String PW;

    public static void admin() throws SQLException, IOException {
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
                //管理员登录
                System.out.print("请输入管理员账号:");
                account = sc.nextLine();
                System.out.print("请输入密码:");
                password = sc.nextLine();
                //检验账户和密码是否正确
                Statement statement = conn1.createStatement();
                String sql = "select aname, apw from AD";
                ResultSet resultSet = statement.executeQuery(sql);
                while(resultSet.next()){  //从AD表中获取管理员的数据，看是否匹配
                    String aname = resultSet.getString("aname");
                    String apw = resultSet.getString("apw");
                    aname = aname.replace(" ","");
                    apw = apw.replace(" ","");
                    if(aname.equals(account) && apw.equals(password) ) {
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

        //管理员可查看，修改NP、CT、OD三个表
        System.out.println("      管理员你好，请选择你的操作");
        boolean flag1 = true;
        while(flag1){
            System.out.println("---------------------------------");
            System.out.println("1.查看表                 2.修改表");
            System.out.println("3.统计表                 4.退出");
            System.out.println("---------------------------------");
            String select = sc.nextLine();
            //查看表
            if(select.equals("1")){
                System.out.println("---------------------------------");
                System.out.println("         请选择你要查看的表");
                System.out.println("1.查看报纸表   2.查看客户表    3.查看订单表");
                System.out.println("---------------------------------");
                String select1 = sc.nextLine();
                switch (select1){
                    case "1": select(1,conn); break;
                    case "2": select(2,conn); break;
                    case "3": select(3,conn); break;
                }
            }
            //修改表
            if(select.equals("2")){
                System.out.println("        请选择你要修改的表");
                System.out.println("1.报纸表   2.客户表    3.订单表");
                System.out.println("---------------------------------");
                String select1 = sc.nextLine();
                if(select1.equals("1")){
                    System.out.println("        请选择你的修改操作");
                    System.out.println("1.插入数据  2.删除数据  3.修改数据");
                    System.out.println("---------------------------------");
                    String select2 = sc.nextLine();
                    switch(select2){
                        case "1":insertNP(conn);break;
                        case "2":deleteNP(conn);break;
                        case "3":updateNP(conn);break;
                    }
                    System.out.println("------------------------------------------------------------------------------");
                    System.out.println("                                修改后的报纸表为");
                    select(1,conn);
                }
                if(select1.equals("2")){
                    System.out.println("        请选择你的修改操作");
                    System.out.println("1.插入数据  2.删除数据  3.修改数据");
                    System.out.println("---------------------------------");
                    String select2 = sc.nextLine();
                    switch(select2){
                        case "1":insertCT(conn);break;
                        case "2":deleteCT(conn);break;
                        case "3":updateCT(conn);break;
                    }
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("                             修改后的客户表为");
                    select(2,conn);
                }
                if(select1.equals("3")){
                    System.out.println("        请选择你的修改操作");
                    System.out.println("1.插入数据  2.删除数据  3.修改数据");
                    System.out.println("---------------------------------");
                    String select2 = sc.nextLine();
                    switch (select2){
                        case "1": insertOD(conn);break;
                        case "2": deleteOD(conn);break;
                        case "3": updateOD(conn);break;
                    }
                    System.out.println("----------------------------------------------------------------------------------");
                    System.out.println("                                修改后的订单表为");
                    select(3,conn);
                }
            }
            //统计
            if(select.equals("3")){
                System.out.println("---------------------------------");
                System.out.println("          请选择你的操作");
                System.out.println("1.统计某报纸的总订购量和总金额");
                System.out.println("2.统计某客户订购的报纸和总金额");
                System.out.println("---------------------------------");
                String select1 = sc.nextLine();
                switch (select1){
                    case "1": sOdByNp(conn);break;
                    case "2": sOdByCt(conn);break;
                }
            }
            //退出
            if(select.equals("4")){
                flag1 = false;
                System.out.println("再见！");
            }
            else{
                System.out.println();
            }
        }
    }
    //select
    public static void select(int n, Connection conn) throws SQLException {
        Statement statement = conn.createStatement();
        if (n == 1) {
            System.out.println("------------------------------------------------------------------------------");
            String sql = "select * from NP";
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("编号\t\t\t名称\t\t\t\t\t单价\t\t\t\t种类\t\t\t\t\t\t邮发代号");
            System.out.println("------------------------------------------------------------------------------");
            while (resultSet.next()) {
                String nid = resultSet.getString("nid");
                String nname = resultSet.getString("nname");
                String nprice = resultSet.getString("nprice");
                String ncfct = resultSet.getString("ncfct");
                String ncode = resultSet.getString("ncode");
                System.out.println(nid + "\t" + nname + "\t" + nprice + "\t\t\t" + ncfct + "\t\t" + ncode);
            }
        }
        if (n == 2) {
            System.out.println("------------------------------------------------------------------");
            String sql = "select * from CT";
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("编号\t\t\t姓名\t\t\t\t电话\t\t\t\t住址\t\t\t\t邮发代号");
            System.out.println("------------------------------------------------------------------");
            while (resultSet.next()) {
                String cid = resultSet.getString("cid");
                String cname = resultSet.getString("cname");
                String ctel = resultSet.getString("ctel");
                String cadrs = resultSet.getString("cadrs");
                String cposid = resultSet.getString("cposid");
                System.out.println(cid + "\t" + cname + "\t" + ctel + "\t\t" + cadrs + "\t"+cposid);
            }
        }
        if (n == 3) {
            System.out.println("----------------------------------------------------------------------------------");
            String sql = "select * from OD";
            System.out.println("编号\t\t\t报纸编号\t\t客户编号\t\t下单时间\t\t\t\t\t下单数量\t\t\t总金额");
            System.out.println("----------------------------------------------------------------------------------");
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String oid = resultSet.getString("oid");
                String nid = resultSet.getString("nid");
                String cid = resultSet.getString("cid");
                String odate = resultSet.getString("odate");
                String oqty = resultSet.getString("oqty");
                String oprice = resultSet.getString("oprice");
                System.out.println(oid + "\t" + nid + "\t" + cid + "\t" + odate + "\t" + oqty + "\t\t\t\t" + oprice);
            }
        }
    }

    //update on NP
    public static void insertNP(Connection conn) throws SQLException {
        System.out.println("请依次输入要插入的报纸编号 名称 价格 分类 邮发代码");
        Scanner sc = new Scanner(System.in);
        String nid = sc.nextLine();
        String nname = sc.nextLine();
        String nprice = sc.nextLine();
        String ncfct = sc.nextLine();
        String ncode = sc.nextLine();

        PreparedStatement preparedStatement;
        String sql = "insert into NP(nid,nname,nprice,ncfct,ncode) values (?,?,?,?,?)";
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1,nid);
        preparedStatement.setString(2,nname);
        preparedStatement.setString(3,nprice);
        preparedStatement.setString(4,ncfct);
        preparedStatement.setString(5,ncode);
        int count = preparedStatement.executeUpdate();
        System.out.println("插入成功！ "+count+" 行受影响");
    }
    public static void deleteNP(Connection conn) throws SQLException {
        System.out.print("请输入要删除的报纸编号：");
        Scanner sc = new Scanner(System.in);
        String nid = sc.nextLine();

        PreparedStatement preparedStatement;
        String sql = "delete from NP where nid = ?";
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1,nid);
        int count = preparedStatement.executeUpdate();
        System.out.println("删除成功！ "+count+" 行受影响");
    }
    public static void updateNP(Connection conn) throws SQLException{
        System.out.print("请输入要修改的报纸编号：");
        Scanner sc = new Scanner(System.in);
        String nid = sc.nextLine();

        PreparedStatement preparedStatement;
        String sql = "delete from NP where nid = ?";
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1,nid);
        preparedStatement.executeUpdate();

        System.out.println("请依次输入修改后的的报纸编号 名称 价格 分类 邮发代码");
        String nid1 = sc.nextLine();
        String nname = sc.nextLine();
        String nprice = sc.nextLine();
        String ncfct = sc.nextLine();
        String ncode = sc.nextLine();
        PreparedStatement preparedStatement1;
        String sql1 = "insert into NP(nid,nname,nprice,ncfct,ncode) values (?,?,?,?,?)";
        preparedStatement1 = conn.prepareStatement(sql1);
        preparedStatement1.setString(1,nid1);
        preparedStatement1.setString(2,nname);
        preparedStatement1.setString(3,nprice);
        preparedStatement1.setString(4,ncfct);
        preparedStatement1.setString(5,ncode);
        int count = preparedStatement1.executeUpdate();
        System.out.println("修改成功！ "+count+" 行受影响");

    }

    //update on CT
    public static void insertCT(Connection conn) throws SQLException {
        System.out.println("请依次输入要插入的客户编号 姓名 电话 住址 邮编");
        Scanner sc = new Scanner(System.in);
        String cid = sc.nextLine();
        String cname = sc.nextLine();
        String ctel = sc.nextLine();
        String cadrs = sc.nextLine();
        String cposid = sc.nextLine();

        PreparedStatement preparedStatement;
        String sql = "insert into CT(cid,cname,ctel,cadrs,cposid) values (?,?,?,?,?)";
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1,cid);
        preparedStatement.setString(2,cname);
        preparedStatement.setString(3,ctel);
        preparedStatement.setString(4,cadrs);
        preparedStatement.setString(5,cposid);
        int count = preparedStatement.executeUpdate();
        System.out.println("插入成功！ "+count+" 行受影响");
    }
    public static void deleteCT(Connection conn) throws SQLException {
        System.out.print("请输入要删除的客户编号：");
        Scanner sc = new Scanner(System.in);
        String cid = sc.nextLine();

        PreparedStatement preparedStatement;
        String sql = "delete from CT where cid = ?";
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1,cid);
        int count = preparedStatement.executeUpdate();
        System.out.println("删除成功！ "+count+" 行受影响");
    }
    public static void updateCT(Connection conn) throws SQLException{
        System.out.print("请输入要修改的客户编号：");
        Scanner sc = new Scanner(System.in);
        String cid = sc.nextLine();

        PreparedStatement preparedStatement;
        String sql = "delete from CT where cid = ?";
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1,cid);
        preparedStatement.executeUpdate();

        System.out.println("请依次输入修改后的的客户编号 姓名 电话 住址 邮编");
        String cid1 = sc.nextLine();
        String cname = sc.nextLine();
        String ctel = sc.nextLine();
        String cadrs = sc.nextLine();
        String cposid = sc.nextLine();
        PreparedStatement preparedStatement1;
        String sql1 = "insert into CT(cid,cname,ctel,cadrs,cposid) values (?,?,?,?,?)";
        preparedStatement1 = conn.prepareStatement(sql1);
        preparedStatement1.setString(1,cid1);
        preparedStatement1.setString(2,cname);
        preparedStatement1.setString(3,ctel);
        preparedStatement1.setString(4,cadrs);
        preparedStatement1.setString(5,cposid);
        int count = preparedStatement1.executeUpdate();
        System.out.println("修改成功！ "+count+" 行受影响");

    }

    //update on OD
    public static void insertOD(Connection conn) throws SQLException {
        System.out.println("请依次输入要插入的订单编号 报纸编号 客户编号 下单日期 下单数量 总金额");
        Scanner sc = new Scanner(System.in);
        String oid = sc.nextLine();
        String nid = sc.nextLine();
        String cid = sc.nextLine();
        String odate = sc.nextLine();
        String oqty = sc.nextLine();
        String oprice = sc.nextLine();

        PreparedStatement preparedStatement;
        String sql = "insert into OD(oid,nid,cid,odate,oqty,oprice) values (?,?,?,?,?,?)";
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1,oid);
        preparedStatement.setString(2,nid);
        preparedStatement.setString(3,cid);
        preparedStatement.setString(4,odate);
        preparedStatement.setString(5,oqty);
        preparedStatement.setString(6,oprice);
        int count = preparedStatement.executeUpdate();
        System.out.println("插入成功！ "+count+" 行受影响");
    }
    public static void deleteOD(Connection conn) throws SQLException {
        System.out.print("请输入要删除的订单编号：");
        Scanner sc = new Scanner(System.in);
        String oid = sc.nextLine();

        PreparedStatement preparedStatement;
        String sql = "delete from OD where oid = ?";
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1,oid);
        int count = preparedStatement.executeUpdate();
        System.out.println("删除成功！ "+count+" 行受影响");
    }
    public static void updateOD(Connection conn) throws SQLException{
        System.out.print("请输入要修改的订单编号：");
        Scanner sc = new Scanner(System.in);
        String oid = sc.nextLine();

        PreparedStatement preparedStatement;
        String sql = "delete from OD where oid = ?";
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1,oid);
        preparedStatement.executeUpdate();

        System.out.println("请依次输入要插入的订单编号 报纸编号 客户编号 下单日期 下单数量 总金额");
        String oid1 = sc.nextLine();
        String nid = sc.nextLine();
        String cid = sc.nextLine();
        String odate = sc.nextLine();
        String oqty = sc.nextLine();
        String oprice = sc.nextLine();

        PreparedStatement preparedStatement1;
        String sql1 = "insert into OD(oid,nid,cid,odate,oqty,oprice) values (?,?,?,?,?,?)";
        preparedStatement1 = conn.prepareStatement(sql1);
        preparedStatement1.setString(1,oid1);
        preparedStatement1.setString(2,nid);
        preparedStatement1.setString(3,cid);
        preparedStatement1.setString(4,odate);
        preparedStatement1.setString(5,oqty);
        preparedStatement1.setString(6,oprice);
        int count = preparedStatement.executeUpdate();
        System.out.println("插入成功！ "+count+" 行受影响");

    }

    //statistic
    public static void sOdByNp(Connection conn) throws SQLException {
        System.out.println("---------------------------------");
        System.out.print("请输入要统计的报纸编号：");
        String nid = new Scanner(System.in).nextLine();

        PreparedStatement preparedStatement;
        String sql ="select sum(oqty),sum(oprice) from OD where nid = ?";
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1,nid);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            String sumOqty = resultSet.getString(1);
            String sumOprice = resultSet.getString(2);
            System.out.println("---------------------------------");
            System.out.println("报纸编号      总订购量      总金额");
            System.out.println(nid + "        " + sumOqty + "         " + sumOprice);
            System.out.println("---------------------------------");
        }
    }
    public static void sOdByCt(Connection conn) throws SQLException {
        System.out.println("---------------------------------");
        System.out.print("请输入要统计的客户编号：");
        String cid = new Scanner(System.in).nextLine();

        PreparedStatement preparedStatement;
        String sql ="select cid,ncfct,oqty,oprice from NP,OD,CT where cid = ? and NP.nid = OD.nid";
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1,cid);
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println("-----------------------------------------");
        while(resultSet.next()){
            String cid1 = resultSet.getString(1);
            String ncfct = resultSet.getString(2);
            String oqty = resultSet.getString(3);
            String oprice = resultSet.getString(4);
            System.out.println(cid1 + "   " + ncfct + oqty + "    " + oprice);
        }
        System.out.println("-----------------------------------------");
    }
}
