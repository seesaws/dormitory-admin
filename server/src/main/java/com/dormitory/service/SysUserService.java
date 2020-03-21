package com.dormitory.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dormitory.entity.SysUser;

/**
 * @ClassName SysUserService
 * @Description TODO
 * @Author CoderL
 * @Date 2020/3/2 17:20
 **/
public interface SysUserService extends IService<SysUser> {
    Page<SysUser> queryUserIncludeRoles(Page page, String nick);

}
