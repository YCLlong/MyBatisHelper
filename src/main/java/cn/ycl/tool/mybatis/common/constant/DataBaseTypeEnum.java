package cn.ycl.tool.mybatis.common.constant;

import com.sun.org.apache.regexp.internal.RE;
import lombok.Getter;

/**
 * 数据库类型枚举类
 */
@Getter
public enum DataBaseTypeEnum {
    MYSQL(100,"MySQL","com.mysql.jdbc.Driver","jdbc:mysql://","characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai"),
    ORACLE(101,"Oracle","oracle.jdbc.driver.OracleDriver","jdbc:oracle:thin:@",""),
    SQL_SERVER(102,"Microsoft SQLServer","com.microsoft.jdbc.sqlserver.SQLServerDriver","jdbc:sqlserver://","")
    ;
    /**
     * 编号
     */
    private int code;

    /**\
     * 名称
     */
    private String name;

    /**
     * 驱动名称
     */
    private String driverClassName;

    /**
     * 数据库连接url前缀
     */
    private String urlPrefix;

    /**
     * 数据库连接url后缀
     */
    private String urlSuffix;


    private  DataBaseTypeEnum(int code, String name, String driverClassName, String urlPrefix, String urlSuffix) {
        this.code = code;
        this.name = name;
        this.driverClassName = driverClassName;
        this.urlPrefix = urlPrefix;
        this.urlSuffix = urlSuffix;
    }

    public static DataBaseTypeEnum findByCode(Integer code){
        if(code == null){
            return null;
        }
        for(DataBaseTypeEnum temp:DataBaseTypeEnum.values()){
            if(temp.getCode() == code){
                return temp;
            }
        }
        return null;
    }

    public static DataBaseTypeEnum recognizeByUrl(String url){
        if(url == null || "".equals(url)){
            return null;
        }
        String[] splitUrls = url.split(":");
        if(splitUrls.length < 3){
            return null;
        }
        String sign = splitUrls[1].toLowerCase();
        if(sign.contains("mysql")){
            return DataBaseTypeEnum.MYSQL;
        }else if(sign.contains("oracle")){
            return DataBaseTypeEnum.ORACLE;
        }else if(sign.contains("sqlserver")){
            return DataBaseTypeEnum.SQL_SERVER;
        }
        return null;
    }
}
