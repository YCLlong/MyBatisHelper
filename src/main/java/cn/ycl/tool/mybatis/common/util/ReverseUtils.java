package cn.ycl.tool.mybatis.common.util;

import cn.ycl.tool.mybatis.db.FieldInfo;

import javax.validation.constraints.NotNull;

/**
 * 逆向工程工具类
 * 将数据库中的表名转换成类名，字段名转化成类中的属性名，遵循驼峰式命名样式
 * 生成set，get方法
 *
 */
public class ReverseUtils {

    /**
     * 将数据库表名称转换成Java的类名称
     * @param tableName         数据库中的表名
     * @param connectorChars    表名中，多个单词的连接字符
     * @return
     */
    public static String convertTableName(@NotNull String tableName, @NotNull String connectorChars){
        //将首字符变成大写
        StringBuffer sb =   coreConvert(tableName,connectorChars);
        sb.replace(0,1,toUpperCase(sb.charAt(0)));
        return sb.toString();
    }

    /**
     * 将数据库表名称转换成Java的类名称
     * @param tableName         数据库中的表名
     * @return
     */
    public static String convertTableName(@NotNull String tableName){
        return convertTableName(tableName,"_");
    }

    /**
     * 将数据库表的字段名称转换成Java的属性名称
     * @param columnName         数据库中的表的字段
     * @param connectorChars    表名中，多个单词的连接字符
     * @return
     */
    public static String convertColumnName(@NotNull String columnName, @NotNull String connectorChars){
        //将首字符变成小写
        StringBuffer sb =   coreConvert(columnName,connectorChars);
        sb.replace(0,1,toLowerCase(sb.charAt(0)));
        return sb.toString();
    }

    /**
     * 将数据库表的字段名称转换成Java的属性名称
     * @param columnName         数据库中的表的字段
     * @return
     */
    public static String convertColumnName(@NotNull String columnName){
        return convertColumnName(columnName,"_");
    }

    /**
     * 将数据库表列名转换成set方法
     * @param columnName
     * @return
     */
    public static String convertSetMethodName(@NotNull FieldInfo columnName){

        return "";
    }


    /**
     * 将数据库表列名转换成get方法
     * @param columnName
     * @return
     */
    public static String convertGetMethodName(@NotNull String columnName){

        return "";
    }


    public static String toUpperCase(char c){
       return String.valueOf(c).toUpperCase();
    }

    public static String toLowerCase(char c){
        return String.valueOf(c).toLowerCase();
    }

    /**
     * 核心处理方法，可惜不会用正则啊，不过这样好维护点
     * @param tableName
     * @param connectorChars
     * @return
     */
    private static StringBuffer coreConvert(String tableName, String connectorChars){
        StringBuffer sb = new StringBuffer(tableName.replaceAll(" ","").toLowerCase());//去掉空格并转换成小写
        //去掉端的连接符
        if(sb.substring(0,1).equals(connectorChars)){
            sb.delete(0,1);
        }
        int length = sb.length();
        if(sb.substring(length-1,length).equals(connectorChars)){
            sb.delete(length-1,length);
        }
        //查找连接符，将连接符后面的字符变成大写
        int index = 1;
        for(;;){
            index = sb.indexOf(connectorChars,index);
            if(index == -1){
                break;
            }
            sb.replace(index + 1,index + 2,toUpperCase(sb.charAt(index + 1)));
            //删除连接符
            sb.delete(index,index+1);
        }
        return sb;
    }
}
