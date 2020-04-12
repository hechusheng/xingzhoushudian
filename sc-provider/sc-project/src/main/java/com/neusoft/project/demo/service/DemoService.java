package com.neusoft.project.demo.service;

import com.neusoft.project.demo.dao.DemoDao;
import com.neusoft.project.demo.entity.StudentEntity;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.time.TimestampUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * <p>demo service.</p>
 * <p>创建日期：2018-05-14</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Service
public class DemoService {

    @Autowired
    private DemoDao demoDao;

    /**
     * 保存学生信息
     *
     * @param studentEntity 学生信息
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveStudent(StudentEntity studentEntity) {
        Timestamp now = TimestampUtils.now();
        //设置创建时间
        studentEntity.setGmtCreate(now);
        //设置更新时间
        studentEntity.setGmtModified(now);
        //设置操作人id
        String userId = SecurityUtils.getCurrentUserId();
        studentEntity.setOperator(userId);

        demoDao.saveStudent(studentEntity);
    }

    /**
     * 获取学生信息
     *
     * @param name 学生名称，模糊查询
     * @return 学生信息集合
     */
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<StudentEntity> listStudents(String name) {
        //分页，注意使用ByPage结尾
        return demoDao.listStudentsByPage(name);
    }


    /**
     * 删除学生信息
     *
     * @param id 学生id
     */
    @Transactional(rollbackFor = Exception.class)
    public void removeStudent(String id) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(id);

        Timestamp now = TimestampUtils.now();
        //设置更新时间
        studentEntity.setGmtModified(now);
        //设置操作人id
        String userId = SecurityUtils.getCurrentUserId();
        studentEntity.setOperator(userId);
        demoDao.removeStudent(studentEntity);
    }

    /**
     * 修改学生信息
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateStudent(StudentEntity studentEntity) {
        Timestamp now = TimestampUtils.now();
        //设置更新时间
        studentEntity.setGmtModified(now);
        //设置操作人id
        String userId = SecurityUtils.getCurrentUserId();
        studentEntity.setOperator(userId);
        //更新学生信息
        demoDao.updateStudent(studentEntity);
    }
}
