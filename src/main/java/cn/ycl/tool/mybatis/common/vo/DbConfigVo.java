package cn.ycl.tool.mybatis.common.vo;

import cn.ycl.tool.mybatis.common.constant.Regex;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 数据库连接配置
 */
@Data
public class DbConfigVo {
    @NotNull(message = "请勿非法操作")
    private Integer code;

    @NotBlank(message = "IP地址不能为空")
    @Pattern(regexp = Regex.IP ,message = "错误的IP地址")
    private String ip;

    @NotNull(message = "端口号不能为空")
    @Range(min = 1,max = 65535,message = "错误的端口号范围")
    private Integer port;

    @NotBlank(message = "数据库名称不能为空")
    private String dbName;

    @NotBlank(message = "登录的用户名不能为空")
    private String userName;

    @NotBlank(message = "登录密码不能为空")
    private String password;
}
