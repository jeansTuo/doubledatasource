package com.my.dao;

import com.my.dbfilter.DBSource;
import com.my.model.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeacherMapper {

    @DBSource(name="second")
    List<Teacher> queryTeacher();
}
