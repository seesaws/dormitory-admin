package com.dormitory.vo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UpdateRolePermVo
 * @Description TODO
 * @Author CoderL
 * @Date 2020/3/2 16:54
 **/
public class UpdateRolePermVo implements Serializable {

    private static final long serialVersionUID = -4298069967261564918L;
    private String rid;
    private Integer ptype;
    private List<String> pvals=new ArrayList<>();


    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public Integer getPtype() {
        return ptype;
    }

    public void setPtype(Integer ptype) {
        this.ptype = ptype;
    }

    public List<String> getPvals() {
        return pvals;
    }

    public void setPvals(List<String> pvals) {
        this.pvals = pvals;
    }
}
