package cn.ycl.tool.mybatis.db;

import lombok.Data;

/**\
 * 字段信息封装
 */
@Data
public class FieldInfo {
    /**
     * 字段名称
     */
    private String name;

    /**
     * 元数据字段名称
     */
    private String metaName;

    /**
     * 字段类型
     */
    private String type;

    /**
     * 元数据字段类型
     */
    private String metaType;
}
