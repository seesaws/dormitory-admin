package com.dormitory.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dormitory.annotation.PermInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author CoderL
 * @Date 2020/2/28 14:59
 **/
@PermInfo(value = "测试模块", pval = "a:sys:test")
@RestController
public class TestController {

    @RequestMapping("/test")
    public JSON test(){
        JSONObject t=new JSONObject();
        t.put("code","success");
        return t;
    }
}
