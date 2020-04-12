package com.xzsd.pc.commodity.controller;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.AuthUtils;
import com.xzsd.pc.commodity.entity.CmdInfo;
import com.xzsd.pc.commodity.service.CmdService;
import com.xzsd.pc.commoditySort.entity.CmdSortInfo;
import com.xzsd.pc.commoditySort.entity.FirstClassSort;
import com.xzsd.pc.commoditySort.entity.SecondClassSort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hechusheng
 * @Descritption增删查改Commodity
 * @Date 2020-03-24
 */
@RestController
@RequestMapping("/commodity")
public class CmdController {
    private static final Logger logger = LoggerFactory.getLogger(CmdController.class);

    @Resource
    private CmdService cmdService;

    /**
     * demo 新增商品
     * @param cmdInfo
     * @return AppResponse
     * @author hechusheng
     * @Date 2020-03-27
     */
    @PostMapping("addCommodity")
    public AppResponse addCommodity(CmdInfo cmdInfo){
        try{
            //获取用户编号
            String userCode = AuthUtils.getCurrentUserId();
            cmdInfo.setCreateUser(userCode);
            cmdInfo.setUpdateUser(userCode);
            return cmdService.addCommodity(cmdInfo);
        }catch (Exception e){
            logger.error("商品新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * demo 商品列表(分页)
     * @param cmdInfo
     * @return AppResponse
     * @author hechusheng
     * @Date 2020-03-27
     */
    @RequestMapping(value = "listCommodity")
    public AppResponse listUsers(CmdInfo cmdInfo) {
        try {
            return cmdService.listCommodity(cmdInfo);
        } catch (Exception e) {
            logger.error("查询商品列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * demo 修改商品
     * @param cmdInfo
     * @return AppResponse
     * @author hechusheng
     * @Date 2020-03-27
     */
    @RequestMapping(value = "updateCommodityByCode")
    public AppResponse updateCommodityByCode(CmdInfo cmdInfo) {
        try {
            //获取用户编号
            String userId = AuthUtils.getCurrentUserId();
            cmdInfo.setUpdateUser(userId);
            return cmdService.updateCommodityByCode(cmdInfo);

        }catch (Exception e) {
            logger.error("商品修改失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除商品
     * @param comCode
     * @return
     * @author hechusheng
     * @Date 2020-03-27
     */
    @PostMapping("deleteCommodity")
    public AppResponse deleteUser(String comCode) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            return cmdService.deleteCommodity(comCode,userId);
        } catch (Exception e) {
            logger.error("商品删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品详情
     * @param comCode
     * @return
     */
    @RequestMapping(value = "findCommodityByCode")
    public AppResponse findCommodityByCode (String comCode) {
        try{
            return cmdService.findCommodityByCode(comCode);
        }catch(Exception e) {
            logger.error("查询商品失败",e);
            System.out.println(e.toString());
            throw e;
        }

    }
    /**
     * demo 修改商品上架/下架
     * @param comCode
     * @return AppResponse
     * @author hechusheng
     * @Date 2020-03-27
     */
    @PostMapping(value = "updateComStatus")
    public AppResponse updateComStatus(String comCode,String comStatus) {
        try {
            //获取用户编号
            String userId = SecurityUtils.getCurrentUserId();
            return cmdService.updateComStatus(comCode,userId,comStatus);
        }catch (Exception e) {
            logger.error("商品修改失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 一级分类下拉查询
     * @return
     */
    @RequestMapping(value = "listFirstClass")
    public AppResponse listFirstClass (){
        try{
            return cmdService.listFirstClass();
        }catch (Exception e) {
            logger.error("一级分类下拉查询失败！",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 二级分类下拉查询
     * @param firstSortCode
     * @return
     */
    @RequestMapping(value = "listSecondClass")
    public AppResponse listSecondClass (String firstSortCode){
        try{
            return cmdService.listSecondClass(firstSortCode);
        }catch (Exception e) {
            logger.error("一级分类下拉查询失败！",e);
            System.out.println(e.toString());
            throw e;
        }
    }
//    @RequestMapping(value = "listCommodity")
//    public AppResponse listUsers(CmdInfo cmdInfo,String key) {
//        try {
//            return cmdService.listCommodity(cmdInfo,key);
//        } catch (Exception e) {
//            logger.error("查询商品列表异常", e);
//            System.out.println(e.toString());
//            throw e;
//        }
//    }

}
