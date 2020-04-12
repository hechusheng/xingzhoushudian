package com.xzsd.pc.menu.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.menu.entity.MenuInfo;
import com.xzsd.pc.menu.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hechusheng
 * @Descritption增删查改Menu
 * @Date 2020-04-10
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
    @Resource
    private MenuService menuService;

    /**
     * 新增菜单
     * @param menuInfo
     * @return
     */
    @PostMapping("addMenu")
    public AppResponse addMenu(MenuInfo menuInfo) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            menuInfo.setCreateUser(userId);
            menuInfo.setUpdateUser(userId);
            return menuService.addMenu(menuInfo);
        } catch (Exception e) {
            logger.error("新增菜单失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询菜单详情
     * @param menuCode
     * @return
     */
    @RequestMapping(value = "findMenuByCode")
    public AppResponse findMenuByCode(String menuCode) {
        try {
            return menuService.findMenuByCode(menuCode);
        }catch (Exception e) {
            logger.error("查询菜单失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改菜单
     * @param menuInfo
     * @return
     */
    @PostMapping("updateMenuByCode")
    public AppResponse updateMenuByCode (MenuInfo menuInfo) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            menuInfo.setUpdateUser(userId);
            return menuService.updateMenuByCode(menuInfo);
        }catch (Exception e) {
            logger.error("修改菜单失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询菜单列表
     * @param menuInfo
     * @return
     */
    @RequestMapping(value = "listMenu")
    public AppResponse listMenu (MenuInfo menuInfo) {
        try {
            return menuService.listMenu(menuInfo);
        }catch (Exception e) {
            logger.error("查询菜单失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除菜单
     * @param menuCode
     * @return
     */
    @PostMapping("deleteMenu")
    public AppResponse deleteMenu (String menuCode) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            return menuService.deleteMenu(menuCode,userId);
        }catch (Exception e) {
            logger.error("删除菜单失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
