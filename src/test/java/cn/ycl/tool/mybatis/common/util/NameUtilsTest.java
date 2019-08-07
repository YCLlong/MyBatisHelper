package cn.ycl.tool.mybatis.common.util;

import org.junit.Test;

public class NameUtilsTest {

    @Test
    public void nameUtilsTest() {
        String v1 = ReverseUtils.convertTableName("- a B cd -FGH","-");
        System.out.println(v1);

        String v2 = ReverseUtils.convertTableName("tb_account");
        System.out.println(v2);

        String v3 = ReverseUtils.convertColumnName("other_link_name");
        System.out.println(v3);
    }
}
