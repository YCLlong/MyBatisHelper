package cn.ycl.tool.mybatis.reverse;

import cn.ycl.tool.mybatis.db.TableInfo;

import java.util.List;

/**
 * @Auther: ycl
 * @Date: 2019/5/31 17:21
 * @Description:
 */
public class JavaReverse implements IReverse {
    /**
     * 逆向生成一个java类
     *
     * @param table
     * @return
     */
    @Override
    public ReverseFile reverse(TableInfo table) {
        ReverseFile file = new ReverseFile();



        return null;
    }

    /**
     * 逆向生成一批类
     *
     * @param tableInfoList
     * @return
     */
    @Override
    public List<ReverseFile> reverse(List<TableInfo> tableInfoList) {
        return null;
    }
}
