package cn.ycl.tool.mybatis.metadata;

import cn.ycl.tool.mybatis.common.constant.DataBaseTypeEnum;
import cn.ycl.tool.mybatis.common.vo.DbConfigVo;
import cn.ycl.tool.mybatis.db.*;

import javax.validation.constraints.NotNull;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public  class DefaultMetaData implements IMetaData {
    private Connection connection;
    private DataBaseTypeEnum dataBaseType;
    private JdbcConfig config;
    public DefaultMetaData(@NotNull JdbcConfig config) throws SQLException, ClassNotFoundException {
        connection =  DataBaseConnectionUtils.getConnection(config);
        this.config = config;
        this.dataBaseType = DataBaseTypeEnum.recognizeByUrl(config.getUrl());
    }

    @Override
    public List<String> getTableName(String dataBaseName) throws SQLException {
        //根据元数据查询当前所连数据库的表信息
        String[] types = {"TABLE"};
        return getEntityName(dataBaseName,types);
    }

    @Override
    public List<String> getViewName(String dataBaseName) throws SQLException {
        String[] types = {"VIEW"};
        return getEntityName(dataBaseName,types);
    }

    @Override
    public List<FieldInfo> getField(String tableName) throws SQLException {
        //根据表名用sql查询，但无需获得数据，只需要元数据即可
        String sql =  "SELECT * FROM "+tableName+" WHERE 1 = 0";
        Statement stmt = connection.createStatement();
        ResultSet results = stmt.executeQuery(sql);
        //获得sql查询的元数据并打印
        ResultSetMetaData rsmd = results.getMetaData();
        List<FieldInfo> list = new ArrayList<FieldInfo>();
        for(int i = 1;i <= rsmd.getColumnCount();i ++){
            FieldInfo info = new FieldInfo();
            info.setMetaName(rsmd.getColumnName(i));
            info.setMetaType(rsmd.getColumnClassName(i));
            list.add(info);
        }
        return list;
    }

    /**
     * 获取实体名称，数据库或者表名
     * @param dataBaseName
     * @param types
     * @return
     * @throws SQLException
     */
    private List<String> getEntityName(String dataBaseName, String[] types ) throws SQLException {
        DatabaseMetaData dbmd= connection.getMetaData();
        List<String> list = new ArrayList<>();
        if(dataBaseType == DataBaseTypeEnum.ORACLE){
            //TODO oracle 的schema 一般是用户名的大写,这儿写死了，不一定对
            ResultSet rs = dbmd.getTables(null, config.getUserName().toUpperCase(), "%", types);
            ResultSetMetaData rc = rs.getMetaData();
            while(rs.next()){
                String name = rs.getString(3);
                list.add(name);
            }
        }else if(dataBaseType == DataBaseTypeEnum.SQL_SERVER){
            ResultSet rs = dbmd.getTables(dataBaseName,null, "%", types);
            ResultSetMetaData rc = rs.getMetaData();
            while(rs.next()){
                //针对sqlserver  存在系统视图
                String schem = rs.getString(2);
                if(schem != null && !"".equals(schem)){
                    if("sys".equals(schem)){
                        continue;
                    }
                }
                String name = rs.getString(3);
                list.add(name);
            }
        }else {
            //MSQL 或者其他
            ResultSet rs = dbmd.getTables(dataBaseName,null, "%", types);
            ResultSetMetaData rc = rs.getMetaData();
            while(rs.next()){
                String name = rs.getString(3);
                list.add(name);
            }
        }
        return list;
    }

    /**
     * 查询元数据并封装
     * @return
     */
    public final DataBaseInfo getDataBaseInfo(@NotNull String dataBaseName) throws SQLException {
        DataBaseInfo info = new DataBaseInfo();
        info.setName(dataBaseName);
        //表名
        List<String> tables = getTableName(dataBaseName);
        if(tables == null || tables.size() == 0){
            info.setTables(null);
        }else {
            info.setTables(getTableInfo(tables));
        }

        //视图名
        List<String> views = getViewName(dataBaseName);
        if(views == null || views.size() == 0){
            info.setViews(null);
        }else {
            info.setViews(getTableInfo(views));
        }
        return info;
    }

    /**
     * 封装表或者视图信息
     * @param names
     * @return
     * @throws SQLException
     */
    private List<TableInfo> getTableInfo( List<String> names) throws SQLException {
        if(names == null || names.size() == 0){
            return null;
        }
        List<TableInfo> tableInfoList = new ArrayList<>();
        for(String name:names){
            TableInfo tableInfo = new TableInfo();
            tableInfo.setMetaName(name);
            tableInfo.setFields(getField(name));
            tableInfoList.add(tableInfo);
        }
        return tableInfoList;
    }

}
