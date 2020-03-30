package com.dormitory.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dormitory.entity.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName StudentMapper
 * @Description TODO
 * @Author CoderL
 * @Date 2020/3/25 18:11
 **/
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
