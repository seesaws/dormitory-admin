package com.dormitory.vo;

import java.io.Serializable;

/**
 * @ClassName Option
 * @Description 通用选项对象
 * @Author CoderL
 * @Date 2020/3/2 16:51
 **/
public class Option implements Serializable {


    private static final long serialVersionUID = 1259721137327221220L;
    private Serializable id;
    private String val;
    private String val2;


    public Option() {
    }

    public Option(Serializable id, String val) {
        this.id = id;
        this.val = val;
    }

    public Option(Serializable id, String val, String val2) {
        this.id = id;
        this.val = val;
        this.val2 = val2;
    }

    public Serializable getId() {
        return id;
    }

    public void setId(Serializable id) {
        this.id = id;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getVal2() {
        return val2;
    }

    public void setVal2(String val2) {
        this.val2 = val2;
    }
}
