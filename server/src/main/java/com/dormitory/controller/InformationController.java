package com.dormitory.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dormitory.annotation.PermInfo;
import com.dormitory.entity.Student;
import com.dormitory.entity.SysUser;
import com.dormitory.service.StudentService;
import com.dormitory.vo.Json;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName InformationController
 * @Description TODO
 * @Author CoderL
 * @Date 2020/3/25 18:00
 **/
@PermInfo(value = "信息模块", pval = "a:sys:information")
@RequestMapping("/info")
@RestController
public class InformationController {
    private static final Logger log = LoggerFactory.getLogger(InformationController.class);

    @Autowired
    StudentService studentService;

    @PermInfo("修改个人信息")
    @GetMapping("/detail")
    public Json get(String body) {

        String oper = "get student information";
        log.info("{}, body: {}",oper,body);

        // 获取当前用户 uid
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
//        System.out.println(" uid："+user.getUid());
//        Student student = JSON.parseObject(body, Student.class);
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        Student student = studentService.getById(user.getUid());
        if(student==null){
            Student student1=new Student();
            student1.setUid(user.getUid());
            studentService.saveOrUpdate(student1);
            return Json.succ(oper).data("student",student1);
        }

        else
        student.setUid(user.getUid());
        return Json.succ(oper).data("student",student);
    }

    @PermInfo("更新个人信息")
    @PatchMapping("/update")
    public Json update(@RequestBody String body){

        String oper = "update student information";
        log.info("{},body:{}",oper,body);

        Student student = JSON.parseObject(body, Student.class);
        // 判断空格、制表符、换行符等 isEmpty 为 false
        if (StringUtils.isBlank(student.getStuno())) {
            return Json.fail(oper, "学号不能为空");
        }
        boolean result = studentService.updateById(student);

        return Json.result(oper,result);
    }
    
}
