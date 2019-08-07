package cn.ycl.tool.mybatis.metadata;

import cn.ycl.tool.mybatis.db.FieldInfo;

import java.sql.SQLException;
import java.util.List;

/**
 * 获取元数据的接口
 */
public interface IMetaData {

    /**
     * 获取数据库中所有的表名
     * @param dataBaseName              数据库名称
     * @return
     */
    List<String> getTableName(String dataBaseName) throws SQLException;

    /**
     * 获取数据库中所有的视图名
     * @param dataBaseName              数据库名称
     * @return
     */
    List<String> getViewName(String dataBaseName) throws SQLException;

    /**
     * 获取一个表中的所有属性名
     * @param tableName                 表名或者视图名
     * @return
     */
    List<FieldInfo> getField(String tableName) throws SQLException;
}
