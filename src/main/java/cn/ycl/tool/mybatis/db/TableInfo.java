package cn.ycl.tool.mybatis.db;

import lombok.Data;

import java.util.List;

/**
 * 表信息封装
 */
@Data
public class TableInfo {
    /**
     * 表名
     */
    private String name;

    /**
     * 元数据表名
     */
    private String metaName;

    /**
     * 字段名
     */
    private List<FieldInfo> fields;
}
