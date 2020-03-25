package com.dormitory.controller;

/**
 * @ClassName OptionController
 * @Description TODO
 * @Author CoderL
 * @Date 2020/3/3 17:05
 **/

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dormitory.annotation.PermInfo;
import com.dormitory.entity.SysRole;
import com.dormitory.service.SysRoleService;
import com.dormitory.vo.Json;
import com.dormitory.vo.Option;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@PermInfo(value = "选项模块", pval = "a:sys:option")
@RestController
@RequestMapping("/option")

public class OptionController {

    private static final Logger log = LoggerFactory.getLogger(OptionController.class);

    @Autowired
    private SysRoleService sysRoleService;
    @RequiresPermissions("a:sys:option:select")
    @GetMapping("/role")
    @PermInfo("查询所有角色列表")
    public Json listRoleOptions() {
        String oper = "list role options";
        log.info(oper);

        QueryWrapper<SysRole> params = new QueryWrapper<>();
        params.select("rid","rname","rval");

        List<SysRole> list = sysRoleService.list(params);

        List<Option> options = list.stream().map(obj -> new Option(obj.getRid(), obj.getRname(),obj.getRval())).collect(Collectors.toList());
        System.out.println("options:"+options);

        return Json.succ(oper, "options", options);
    }


}