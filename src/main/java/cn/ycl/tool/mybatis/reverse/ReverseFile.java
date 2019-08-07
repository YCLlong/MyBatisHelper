package cn.ycl.tool.mybatis.reverse;

import lombok.Data;

/**
 * @Auther: ycl
 * @Date: 2019/5/31 17:14
 * @Description:
 */
@Data
public class ReverseFile {
    /**
     * java类文件名
     */
    private String fileName;

    /**
     * java类文件内容
     */
    private byte[] content;
}
