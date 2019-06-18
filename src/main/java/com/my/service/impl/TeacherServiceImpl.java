package com.my.service.impl;

import com.my.dao.TeacherMapper;
import com.my.model.Teacher;
import com.my.service.ITeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zengwen
 * @version 1.0
 * @date 2019/06/18
 */
@Service
public class TeacherServiceImpl implements ITeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> queryTearcher() {
        return teacherMapper.queryTeacher();
    }
}
