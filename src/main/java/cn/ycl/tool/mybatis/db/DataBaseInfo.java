package cn.ycl.tool.mybatis.db;

import lombok.Data;

import java.util.List;

/**
 * 数据库信息封装
 */
@Data
public class DataBaseInfo {
    /**
     * 数据库名称
     */
    private String name;

    /**
     *表名称
     */
    private List<TableInfo> tables;

    /**
     * 视图名称
     */
    private List<TableInfo> views;
}
