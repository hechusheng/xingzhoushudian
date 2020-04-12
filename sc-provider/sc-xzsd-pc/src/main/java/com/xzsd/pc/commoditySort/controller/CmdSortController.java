package com.xzsd.pc.commoditySort.controller;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.commoditySort.entity.CmdSortInfo;
import com.xzsd.pc.commoditySort.service.CmdSortService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hechusheng
 * @Descritption增删查改commoditySort
 * @Date 2020-03-27
 */

@RestController
@RequestMapping("/commoditySort")
public class CmdSortController {
    private static final Logger logger = LoggerFactory.getLogger(CmdSortController.class);

    @Resource
    private CmdSortService cmdSortService;

    /**
     * demo 新增一级商品分类
     * @param cmdSortInfo
     * @return AppResponse
     * @author hechusheng
     * @Date 2020-03-24
     */
    @PostMapping("addCommoditySort")
    public AppResponse addCommoditySort(CmdSortInfo cmdSortInfo){
        try{
            String userId = SecurityUtils.getCurrentUserId();
            cmdSortInfo.setCreateUser(userId);
            cmdSortInfo.setUpdateUser(userId);
            //新增商品分类
            AppResponse appResponse = cmdSortService.addCommoditySort(cmdSortInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("商品分类新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询分类详情
     * @param sortCode
     * @return
     */
    @RequestMapping("findSortByCode")
    public AppResponse findSortByCode (String sortCode) {
        try {
            return cmdSortService.findSortByCode(sortCode);
        }catch (Exception e) {
            logger.error("商品分类新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * demo 修改商品分类
     * @param cmdSortInfo
     * @return AppResponse
     * @author hechusheng
     * @Date 2020-03-27
     */
    @PostMapping("updateSort")
    public AppResponse updateUser(CmdSortInfo cmdSortInfo) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            cmdSortInfo.setUpdateUser(userId);
            return cmdSortService.updateSort(cmdSortInfo);
        } catch (Exception e) {
            logger.error("修改商品分类信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * demo 商品分类列表
     * @return AppResponse
     * @author hechusheng
     * @Date 2020-03-25
     */
    @RequestMapping(value = "listSorts")
    public AppResponse listSorts() {
        try {
            return cmdSortService.listSorts();
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    @PostMapping("deleteSort")
    public AppResponse deleteSort (String sortCode) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            return cmdSortService.deleteSort(sortCode,userId);
        }catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
