package Demo01;

import java.sql.*;

public class Sqlserver {
    public static void main(String[] args) {
        String user = "sa";
        String password = "sa123456";
        Connection conn;
        Statement stmt;
        ResultSet rs;
        String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=CAP;";
        String sql = "select * from customers";
        try {
            // 连接数据库
            conn = DriverManager.getConnection(url, user, password);
            // 建立Statement对象
            stmt = conn.createStatement();
            // 执行数据库查询语句
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String cid = rs.getString("cid");
                String cname = rs.getString("cname");
                String city = rs.getString("city");
                float discnt = rs.getFloat("discnt");
                System.out.println("顾客ID：" + cid + "\t顾客姓名：" + cname + "\t顾客城市：" + city + "\t顾客折扣：" + discnt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
    }
}
