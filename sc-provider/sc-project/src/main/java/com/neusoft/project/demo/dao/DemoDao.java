package com.neusoft.project.demo.dao;

import com.neusoft.project.demo.entity.StudentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>demo dao接口</p>
 * <p>创建日期：2018-05-14</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Mapper
public interface DemoDao {

    /**
     * 保存学生信息
     *
     * @param studentEntity 学生信息
     * @return 插入条数
     */
    int saveStudent(StudentEntity studentEntity);

    /**
     * 查询学生信息
     *
     * @param name 学生名称，模糊查询
     * @return 学生信息集合
     */
    List<StudentEntity> listStudentsByPage(@Param("name") String name);

    /**
     * 删除学生信息
     *
     * @param studentEntity 学生信息
     * @return 删除条数
     */
    int removeStudent(StudentEntity studentEntity);

    /**
     * 更新学生信息
     *
     * @param studentEntity 学生信息
     * @return 更新条数
     */
    int updateStudent(@Param("studentEntity") StudentEntity studentEntity);

}
