package com.dormitory.util;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName MenuResource
 * @Description TODO
 * @Author CoderL
 * @Date 2020/3/3 15:54
 **/
@Data
public class MenuResource implements Serializable {


    private static final long serialVersionUID = 4977921232378673809L;
    private String menuId;
    private String parentId;
    private String menuName;
    private String menuCode;
    private String reqUrl;
    private Integer orderNum;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
    private List<MenuResource> children = new ArrayList<>();

    public MenuResource(MenuResource m) {
        this.menuId = m.getMenuId();
        this.parentId = m.getParentId();
        this.menuName = m.getMenuName();
        this.menuCode = m.getMenuCode();
        this.reqUrl =  m.getReqUrl();
        this.orderNum = m.getOrderNum();
        this.createdAt = m.getCreatedAt();
        this.updatedAt = m.getUpdatedAt();
        this.deletedAt = m.getDeletedAt();
    }
}




