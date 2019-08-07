package cn.ycl.tool.mybatis.matedata;

import cn.ycl.tool.mybatis.db.DataBaseConnectionUtils;
import cn.ycl.tool.mybatis.db.DataBaseInfo;
import cn.ycl.tool.mybatis.db.JdbcConfig;
import cn.ycl.tool.mybatis.metadata.DefaultMetaData;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class MateDataUtils {

    public JdbcConfig getMysqlConnectionConfig() {
        JdbcConfig config = new JdbcConfig();
        config.setDriverClassName("com.mysql.jdbc.Driver");
        config.setUrl("jdbc:mysql://127.0.0.1:3306/employee?characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai");
        config.setUserName("root");
        config.setPassword("123456");
        return config;
    }

    public JdbcConfig getSqlServerConnectionConfig() {
        JdbcConfig config = new JdbcConfig();
        config.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        config.setUrl("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=classmate");
        config.setUserName("sa");
        config.setPassword("123456");
        return config;
    }

    public JdbcConfig getOracleConnectionConfig() {
        JdbcConfig config = new JdbcConfig();
        config.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        config.setUrl("jdbc:oracle:thin:@192.168.66.201:1521:db");
        config.setUserName("bss");
        config.setPassword("bss");
        return config;
    }


    @Test
    public void metaData() throws SQLException, ClassNotFoundException {
        JdbcConfig config = new MateDataUtils().getOracleConnectionConfig();
       /* List<String> list = new DefaultMetaData(connection).getTableName("classmate");
        List<FieldInfo> fieldInfoList = new DefaultMetaData(connection).getField("tb_user");*/
       DataBaseInfo info = new DefaultMetaData(config).getDataBaseInfo("bss");
        System.out.println(info);
    }






}
