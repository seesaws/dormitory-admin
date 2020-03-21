package com.dormitory.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dormitory.entity.SysPerm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName SysPermMapper
 * @Description TODO
 * @Author CoderL
 * @Date 2020/2/28 17:40
 **/
@Mapper
public interface SysPermMapper extends BaseMapper<SysPerm> {
    List<SysPerm> getPermsByUserId(@Param("userId") String userId);

    List<SysPerm> getPermsByRoleId(@Param("roleId") String roleId);

    void saveOrUpdate(@Param("perms") List<SysPerm> perms);
}
