package Demo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
    数据库连接类,
    将数据库连接封装
 */

public class ConnectSql {
    //数据库地址
    private static final String DBURL = "jdbc:sqlserver://localhost: 1433;DataBaseName=PostOffice";
    //数据库登录用户名
    private static final String DBUSER = "superadmin";
    //数据库用户密码
    private static final String DBPASSWORD = "superadmin123";
    //数据库连接
    public static Connection conn = null;
    //数据库操作
    public static Statement stmt = null;

    public static Statement connect() {
        try {
            //连接数据库
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
            //实例化Statement对象
            stmt = conn.createStatement();
            return stmt;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    /*
        *使用本类范例*

        Statement stmt = ConnectSql.connect();
        ResultSet rs = stmt.executeQuery("select * from newspaper");
        System.out.println("查询到的 报纸信息 如下: ");
        while (rs.next())
        {
            System.out.println(rs.getString(1) + "\t" + rs.getString(2)
            + "\t" + rs.getString(3) + "\t" + rs.getString(4)
            + "\t" + rs.getString(5));
        }
        stmt.close();
     */
}
