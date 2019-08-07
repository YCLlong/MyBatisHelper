package cn.ycl.tool.mybatis.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnectionUtils {

    public static Connection getConnection(JdbcConfig config) throws ClassNotFoundException, SQLException {
        Class.forName(config.getDriverClassName());
        Connection conn = DriverManager.getConnection(config.getUrl(), config.getUserName(), config.getPassword());
        return conn;
    }

    public static void closeConnection(Connection getConnection){
        if(getConnection != null){
            try {
                getConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
