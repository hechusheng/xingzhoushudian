package com.neusoft.project.demo.controller;


import com.neusoft.core.page.PageUtils;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.core.validate.UpdateGroup;
import com.neusoft.project.demo.entity.StudentEntity;
import com.neusoft.project.demo.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * <p>CRUD样例</p>
 * <p>创建日期：2018-05-15</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Api("demo接口")
@RestController
@Validated
@RequestMapping("demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    /**
     * 查询所有学生列表，带分页功能
     *
     * @param name 学生姓名，模糊查询
     * @return 学生结果集
     */
    @ApiOperation(value = "查询所有学生列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", paramType = "query", value = "学生名称，模糊查询", example = "张三")
    })
    @PostMapping(value = "listStudents", produces = MediaType.APPLICATION_JSON)
    public AppResponse listStudents(String name) {
        List<StudentEntity> list = demoService.listStudents(name);

        if (CollectionUtils.isEmpty(list)) {
            return AppResponse.notFound("未查询到结果");
        }

        return AppResponse.success("查询成功", PageUtils.getPageInfo(list));
    }

    /**
     * 保存学生信息
     *
     * @param studentEntity 学生信息
     * @return 操作结果
     */
    @ApiOperation(value = "保存学生信息")
    @PostMapping(value = "saveStudent", consumes = MediaType.APPLICATION_FORM_URLENCODED, produces = MediaType.APPLICATION_JSON)
    public AppResponse saveStudent(@Validated StudentEntity studentEntity) {
        demoService.saveStudent(studentEntity);
        return AppResponse.success("用户保存成功");
    }

    /**
     * 删除学生信息
     *
     * @param id 学生id
     * @return 操作结果
     */
    @ApiOperation("删除学生信息")
    @ApiImplicitParam(name = "id", paramType = "query", value = "学生id")
    @GetMapping(value = "removeStudent", produces = MediaType.APPLICATION_JSON)
    public AppResponse removeStudent(@NotNull(message = "用户id不能为空") String id) {
        demoService.removeStudent(id);
        return AppResponse.success("用户删除成功");
    }

    /**
     * 修改学生信息
     *
     * @param studentEntity
     * @return
     */
    @ApiOperation("修改学生信息")
    @ApiImplicitParam(name = "id", paramType = "query", value = "学生id")
    @PostMapping(value = "updateStudent", consumes = MediaType.APPLICATION_FORM_URLENCODED, produces = MediaType.APPLICATION_JSON)
    public AppResponse updateStudent(@Validated(UpdateGroup.class) StudentEntity studentEntity) {
        demoService.updateStudent(studentEntity);
        return AppResponse.success("修改学生信息成功");
    }

}
