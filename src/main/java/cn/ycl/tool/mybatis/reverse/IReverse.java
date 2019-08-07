package cn.ycl.tool.mybatis.reverse;

import cn.ycl.tool.mybatis.db.DataBaseInfo;
import cn.ycl.tool.mybatis.db.TableInfo;

import java.util.List;

/**
 * @Auther: ycl
 * @Date: 2019/5/31 17:09
 * @Description:
 */
public interface IReverse {
    /**
     * 逆向生成一个java类
     * @param table
     * @return
     */
    ReverseFile reverse(TableInfo table);

    /**
     * 逆向生成一批类
     * @param tableInfoList
     * @return
     */
    List<ReverseFile> reverse(List<TableInfo> tableInfoList);
}
