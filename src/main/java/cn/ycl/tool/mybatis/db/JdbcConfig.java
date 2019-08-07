package cn.ycl.tool.mybatis.db;

import lombok.Data;

/**
 * jdbc连接配置
 */
@Data
public class JdbcConfig {
    /**
     * 用户名
     */
    private String userName;

    /**
     * 数据库登录密码
     */
    private String password;

    /**
     * 数据库连接url
     */
    private String url;

    /**
     * 连接驱动的类名称
     */
    private String driverClassName;
}
