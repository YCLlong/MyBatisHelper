package cn.ycl.tool.mybatis.controller;

import cn.ycl.tool.mybatis.common.vo.DbConfigVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    @RequestMapping("index")
    public String index(@Validated DbConfigVo config, Errors errors, ModelMap map){
        List<FieldError> fieldErrors = errors.getFieldErrors();
        map.put("errors",fieldErrors);
        return "main/index";
    }
}
