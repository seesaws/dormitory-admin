package com.dormitory.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dormitory.dao.SysUserMapper;
import com.dormitory.entity.SysUser;
import com.dormitory.service.SysUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @ClassName SysUserServiceImpl
 * @Description TODO
 * @Author CoderL
 * @Date 2020/3/3 16:09
 **/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public Page queryUserIncludeRoles(Page page, String nick) {
        return page.setRecords(baseMapper.selectUserIncludeRoles(page,nick));
    }

}
