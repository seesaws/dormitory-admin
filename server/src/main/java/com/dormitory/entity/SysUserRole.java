package com.dormitory.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * @ClassName SysUserRole
 * @Description 用户角色实体类
 * @Author CoderL
 * @Date 2020/3/2 16:57
 **/
@TableName("sys_user_role")
public class SysUserRole implements Serializable {
    private static final long serialVersionUID = 6891668257020885548L;
    @TableField("user_id")
    private String userId;
    @TableField("role_id")
    private String roleId;

    public SysUserRole() {
    }

    public SysUserRole(String userId, String roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}

