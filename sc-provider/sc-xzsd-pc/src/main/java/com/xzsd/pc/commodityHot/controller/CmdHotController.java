package com.xzsd.pc.commodityHot.controller;

import com.neusoft.core.exception.ScServerException;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.commodityHot.entity.CmdHotInfo;
import com.xzsd.pc.commodityHot.service.CmdHotService;
import com.xzsd.pc.user.entity.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/commodityHot")
@Validated
public class CmdHotController {

    private static final Logger logger = LoggerFactory.getLogger(CmdHotController.class);
    @Resource
    private CmdHotService cmdHotService;

    /**
     * 新增热门商品
     * @param cmdHotInfo
     * @return
     */
    @PostMapping("addCommodityHot")
    public AppResponse addCommodityHot(@Valid CmdHotInfo cmdHotInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            cmdHotInfo.setCreateUser(userId);
            cmdHotInfo.setUpdateUser(userId);
            AppResponse appResponse = cmdHotService.addCommodityHot(cmdHotInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("新增热门商品失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询热门位商品详情
     * @param hotCode
     * @return
     */
    @RequestMapping("getCommodityHot")
    public AppResponse getCommodityHot (String hotCode) {
        try {
            return cmdHotService.getCommodityHot(hotCode);
        }catch (Exception e) {
            logger.error("新增热门商品失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改热门商品
     * @param cmdHotInfo
     * @return
     */
    @PostMapping("updateCommodityHot")
    public AppResponse updateCommodityHot(CmdHotInfo cmdHotInfo) {
        try {
            //获取当前操作人用户编号
            String userId = SecurityUtils.getCurrentUserId();
            cmdHotInfo.setUpdateUser(userId);
            return cmdHotService.updateCommodityHot(cmdHotInfo);
        }catch (Exception e) {
            logger.error("修改热门商品失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询热门商品列表(分页)
     * @param cmdHotInfo
     * @return
     */
    @RequestMapping("listHotCommodityByPage")
    public AppResponse listHotCommodityByPage (CmdHotInfo cmdHotInfo) {
        try {
            return cmdHotService.listHotCommodityByPage(cmdHotInfo);
        }catch (Exception e) {
            logger.error("查询热门商品列表失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除热门商品
     * @param hotCode
     * @return
     */
    @PostMapping("deleteCommodityHot")
    public AppResponse deleteCommodityHot (String hotCode) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            return cmdHotService.deleteCommodityHot(hotCode,userId);
        }catch (Exception e) {
            logger.error("删除热门商品失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
