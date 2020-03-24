package com.dormitory.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dormitory.annotation.PermInfo;
import com.dormitory.entity.SysNotice;
import com.dormitory.entity.SysRole;
import com.dormitory.entity.SysUser;
import com.dormitory.service.SysNoticeService;
import com.dormitory.util.PageUtils;
import com.dormitory.vo.Json;
import com.mysql.cj.protocol.x.Notice;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;


/**
 * @ClassName NoticeController
 * @Description TODO
 * @Author CoderL
 * @Date 2020/3/15 14:52
 **/

@PermInfo(value = "公告模块", pval = "a:notice")
@RestController
@RequestMapping("/notice")
public class NoticeController {

    private static final Logger log = LoggerFactory.getLogger(NoticeController.class);

    @Resource
    private SysNoticeService noticeService;

    @PermInfo("查询所有系统公告")
    @PostMapping("/query")
    public Object query(@RequestBody String body) {
        String oper = "query notice";
        log.info("{}, body: {}", oper, body);

        QueryWrapper<SysNotice> queryWrapper = new QueryWrapper<>();

        JSONObject json = JSON.parseObject(body);
        int size = json.getIntValue("size");
        int current = json.getIntValue("current");
        if (current == 0) current = 1;
        if (size == 0) size = 10;
        Page<SysNotice> page = noticeService.page(new Page<>(current, size),queryWrapper.orderByDesc("publishtime"));
        return Json.succ(oper).data("page", page);
    }

    @PermInfo("添加系统公告")
    @PostMapping("/create")
    public Json add(@RequestBody String body) {

        String oper = "add sys notice";
        log.info("{}, body: {}",oper,body);

        SysNotice notice = JSON.parseObject(body, SysNotice.class);

        if (StringUtils.isEmpty(notice.getTitle())) {
            return Json.fail(oper, "标题不能为空");
        }
        if (StringUtils.isEmpty(notice.getContent())) {
            return Json.fail(oper, "内容不能为空");
        }
        //保存新数据
        boolean success = noticeService.save(notice);
        return Json.result(oper, success)
                .data("nid",notice.getNid())
                .data("publishtime",notice.getPublishtime());
    }

    @PermInfo("删除系统公告")
    @DeleteMapping("/delete")
    public Json delete(@RequestBody String body) {

        String oper = "delete sys notice";
        log.info("{}, body: {}",oper,body);

        SysNotice notice = JSON.parseObject(body, SysNotice.class);

        boolean success = noticeService.removeById(notice.getNid());
        return Json.result(oper, success);
    }

    @PermInfo("获取系统公告详情")
    @GetMapping("/detail")
    public Json get(String nid) {

        String oper = "get sys notice 获取系统公告";
        log.info("{}, body: {}",oper,nid);

        SysNotice notice = noticeService.getById(nid);
        return Json.succ(oper).data("data",notice);
    }

    @PermInfo("更新系统公告")
    @PatchMapping("/update")
    public Json update(@RequestBody String body) {

        String oper = "update sys notice 更新系统公告";
        log.info("{}, body: {}",oper,body);

        SysNotice notice = JSON.parseObject(body, SysNotice.class);
        notice.setUpdated(new Date());
        boolean result = noticeService.updateById(notice);
        return Json.result(oper,result);
    }


}
