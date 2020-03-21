package com.dormitory.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dormitory.entity.SysRole;
import com.dormitory.vo.AuthVo;

import java.util.List;
import java.util.Set;

/**
 * @ClassName SysRoleService
 * @Description TODO
 * @Author CoderL
 * @Date 2020/3/2 17:20
 **/
public interface SysRoleService extends IService<SysRole> {
    Set<AuthVo> getRolesByUserId(String userId);

    List<String> getRoleIdsByUserId(String userId);

    boolean checkRidsContainRval(List<String> rids, String rval);

    boolean checkUidContainRval(String uid, String rval);

}
