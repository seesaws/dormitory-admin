package com.dormitory.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dormitory.entity.SysPerm;
import com.dormitory.vo.AuthVo;

import java.util.List;
import java.util.Set;

/**
 * @ClassName SysPermService
 * @Description TODO
 * @Author CoderL
 * @Date 2020/3/2 17:19
 **/
public interface SysPermService extends IService<SysPerm> {
    Set<AuthVo> getPermsByUserId(String userId);

    List<SysPerm> getPermsByRoleId(String roleId);

    void saveOrUpdate(List<SysPerm> perms);
}
