package com.neusoft.webauth.menu.controller;

import com.neusoft.core.exception.ScServerException;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.webauth.menu.entity.MenuBtn;
import com.neusoft.webauth.menu.service.MenuBtnService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @ClassName MenuBtnController
 * @Description 菜单管理
 * @Author zhu.qf@neusoft.com
 * @Date 2018/11/28
 */
@RestController
@RequestMapping("/menuBtn")
public class MenuBtnController {

    private static final Logger logger = LoggerFactory.getLogger(MenuBtnController.class);

    @Resource
    private MenuBtnService menuBtnService;

    /**
     * 部门：南京软件研发中心
     * 功能：获取菜单按钮
     * 描述：略
     * 作成者：朱庆锋
     * 作成时间：2018/11/28
     */
    @RequestMapping(value = "listMenuBtns")
    public AppResponse listMenuBtns(MenuBtn menuBtn){
        try {
            Map<String,Object> map= menuBtnService.listMenuBtns(menuBtn);

            return AppResponse.success("查询成功", map);
        }catch (Exception e){
            logger.error("按钮获取异常", e);
            throw new ScServerException("按钮获取失败，请重试");
        }
    }

    /**
     * 部门：南京软件研发中心
     * 功能：菜单按钮删除
     * 描述：略
     * 作成者：朱庆锋
     * 作成时间：2018/11/29
     */
    @RequestMapping(value = "deleteMenuBtn")
    public AppResponse deleteMenuBtn(MenuBtn menuBtn){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            menuBtn.setLastModifiedBy(userId);
            return menuBtnService.deleteMenuBtn(menuBtn);
        }catch (Exception e){
            logger.error("删除按钮失败", e);
            throw new ScServerException("删除按钮错误！");
        }
    }

    /**
     * 部门：南京软件研发中心
     * 功能：菜单按钮新增
     * 描述：略
     * 作成者：朱庆锋
     * 作成时间：2018/11/29
     */
    @RequestMapping(value = "insertMenuBtn")
    public AppResponse insertMenuBtn(MenuBtn menuBtn){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            menuBtn.setCreateBy(userId);
            return menuBtnService.insertMenuBtn(menuBtn);
        }catch (Exception e){
            logger.error("新增按钮失败", e);
            throw new ScServerException("新增按钮失败！");
        }
    }

    /**
     * 部门：南京软件研发中心
     * 功能：修改菜单按钮
     * 描述：略
     * 作成者：朱庆锋
     * 作成时间：2018/11/29
     */
    @RequestMapping(value = "updateMenuBtn")
    public AppResponse updateMenuBtn(MenuBtn menuBtn){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            menuBtn.setCreateBy(userId);
            return menuBtnService.updateMenuBtn(menuBtn);
        }catch (Exception e){
            logger.error("修改按钮失败", e);
            throw new ScServerException("修改按钮失败！");
        }
    }
}
