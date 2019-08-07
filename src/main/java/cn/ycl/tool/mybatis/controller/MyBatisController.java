package cn.ycl.tool.mybatis.controller;

import cn.ycl.tool.mybatis.common.vo.DbConfigVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mybatis")
public class MyBatisController {

    /**
     * 跳转到数据库配置界面
     * @return
     */
    @RequestMapping("configIndex")
    public String dbConfig(){
        return "configIndex";
    }

    @RequestMapping("config")
    public String config(DbConfigVo config){
        return "config";
    }



}
