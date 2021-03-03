package Demo02;

import java.sql.*;

public class Sqlserver2 {
    public static final String URL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=CAP";
    public static final String USER = "sa";
    public static final String PASSWD = "sa123456";

    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWD);

        Statement statement = conn.createStatement();
        String sql = "select * from customers";
        ResultSet set = statement.executeQuery(sql);
        while (set.next()) {
            String cid = set.getString("cid");
            String cname = set.getString("cname");
            String city = set.getString("city");
            float discnt = set.getFloat("discnt");
            System.out.println(cid + " " + cname + " " + city + " " + discnt);
        }
        conn.close();
    }
}
