package com.dormitory.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.dormitory.vo.AuthVo;

import java.io.Serializable;
import java.util.*;

/**
 * @ClassName SysNotice
 * @Description TODO
 * @Author CoderL
 * @Date 2020/3/15 14:58
 **/

@TableName("tb_notice")
public class SysNotice extends Model<SysNotice> {


    private static final long serialVersionUID = 4064741581785880907L;
    @TableId(type = IdType.ASSIGN_ID)
    private String nid;     // 公告id
    private String title;   // 公告标题
    private String content;    // 内容
    private String author;     // 作者
    private Date publishtime;   // 创建时间
    private Date updated;   // 修改时间
    //非数据库字段
    @TableField(exist = false)
    private List<SysNotice> roleList = new ArrayList<>();    //用户所有角色值，在管理后台显示用户的角色

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public List<SysNotice> getNoticeList() {
        return roleList;
    }

    public void setNoticeList(List<SysNotice> roleList) {
        this.roleList = roleList;
    }


}
