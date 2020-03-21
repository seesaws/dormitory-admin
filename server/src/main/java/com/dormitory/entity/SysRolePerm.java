package com.dormitory.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @ClassName SysRolePerm
 * @Description TODO
 * @Author CoderL
 * @Date 2020/2/28 18:00
 **/
@TableName("sys_role_perm")
public class SysRolePerm implements Serializable {

    private static final long serialVersionUID = -8725937686415627602L;
    @TableField("role_id")
    private String roleId;
    @TableField("perm_val")
    private String permVal;
    @TableField("perm_type")
    private Integer permType;

    public SysRolePerm() {
    }

    public SysRolePerm(String roleId, String permVal,Integer permType) {
        this.roleId = roleId;
        this.permVal = permVal;
        this.permType = permType;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermVal() {
        return permVal;
    }

    public void setPermVal(String permVal) {
        this.permVal = permVal;
    }

    public Integer getPermType() {
        return permType;
    }

    public void setPermType(Integer permType) {
        this.permType = permType;
    }
}
