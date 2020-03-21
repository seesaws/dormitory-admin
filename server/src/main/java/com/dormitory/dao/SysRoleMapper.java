package com.dormitory.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dormitory.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName SysRoleMapper
 * @Description TODO
 * @Author CoderL
 * @Date 2020/2/28 17:40
 **/
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysRole> getRolesByUserId(@Param("userId") String userId);

    List<String> getRoleIdsByUserId(@Param("userId") String userId);

    Boolean checkRidsContainRval(@Param("rids")List<String> rids,@Param("rval")String rval);

    Boolean checkUidContainRval(@Param("uid")String uid,@Param("rval")String rval);

}
