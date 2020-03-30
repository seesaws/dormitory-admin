package com.dormitory.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dormitory.dao.StudentMapper;
import com.dormitory.entity.Student;
import com.dormitory.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * @ClassName StudentServiceImpl
 * @Description TODO
 * @Author CoderL
 * @Date 2020/3/25 18:12
 **/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper,Student> implements StudentService {
}
