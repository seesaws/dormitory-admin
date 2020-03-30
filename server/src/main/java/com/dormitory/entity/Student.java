package com.dormitory.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.util.Date;

/**
 * @ClassName Student
 * @Description TODO
 * @Author CoderL
 * @Date 2020/3/25 18:05
 **/
@TableName("tb_studentinfo")
public class Student extends Model<Student> {

    private static final long serialVersionUID = -6553816802849205183L;
    @TableId(type = IdType.ASSIGN_ID)
    private String uid;     // 用户id
    private String stuno;   // 学生学号
    private String stuname;    // 学生姓名
    private String gender;     // 学生性别
    private Integer age;   // 学生年龄
    private String classid;     // 用户班级id
    private String address;     // 学生地址
    private String phone;       // 学生手机
    private String headimgsrc;      //用户头像地址
    private  Date checkin;      //登记日期

    public String getHeadimgsrc() {
        return headimgsrc;
    }

    public void setHeadimgsrc(String headimgsrc) {
        this.headimgsrc = headimgsrc;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getStuno() {
        return stuno;
    }

    public void setStuno(String stuno) {
        this.stuno = stuno;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
