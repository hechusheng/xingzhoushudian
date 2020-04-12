package com.neusoft.webauth.menu.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.neusoft.util.UUIDUtils;
import com.neusoft.webauth.menu.dao.MenuBtnDao;
import com.neusoft.webauth.menu.entity.MenuBtn;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MenuBtnService
 * @Description 菜单管理
 * @Author zhu.qf@neusoft.com
 * @Date 2018/11/28
 */
@Service
public class MenuBtnService {

    @Resource
    private MenuBtnDao menuBtnDao;

    /**
     * 部门：南京软件研发中心
     * 功能：获取菜单按钮列表
     * 描述：略
     * 作成者：朱庆锋
     * 作成时间：2018/11/28
     */
    public Map<String,Object> listMenuBtns(MenuBtn menuBtn) {
        Map<String,Object> resultMap = new HashMap<>();
        // 获取菜单按钮
        List<MenuBtn> list = menuBtnDao.listMenuBtns(menuBtn.getMenuCode());
        resultMap.put("all", list);
        // 如果角色代码不为空，或角色授权的菜单按钮
        if(StringUtils.isNotEmpty(menuBtn.getRoleCode())) {
            List<MenuBtn> btnListChecked = menuBtnDao.listRoleMenuBtns(menuBtn);
            resultMap.put("checked", btnListChecked);
        }
        return resultMap;
    }

    /**
     * 部门：南京软件研发中心
     * 功能：删除菜单按钮
     * 描述：略
     * 作成者：朱庆锋
     * 作成时间：2018/11/28
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteMenuBtn(MenuBtn menuBtn) {
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除角色菜单按钮关联关系
        menuBtnDao.deleteRoleMenuBtnBy(menuBtn);
        // 删除角色菜单按钮信息
        int count = menuBtnDao.deleteMenuBtn(menuBtn);
        if(0 == count) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();// 回滚
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 部门：南京软件研发中心
     * 功能：新增菜单按钮
     * 描述：略
     * 作成者：朱庆锋
     * 作成时间：2018/11/28
     */
    public AppResponse insertMenuBtn(MenuBtn menuBtn) {
        AppResponse appResponse = AppResponse.success("新增成功！");
        menuBtn.setId(UUIDUtils.getUUID());
        // 按钮代码
        menuBtn.setButtonCode(StringUtil.getCommonCode(2));

        int count = menuBtnDao.insertMenuBtn(menuBtn);
        if(0 == count) {
            appResponse = AppResponse.bizError("新增失败！");
        }
        return appResponse;
    }

    /**
     * 部门：南京软件研发中心
     * 功能：修改菜单按钮
     * 描述：略
     * 作成者：朱庆锋
     * 作成时间：2018/11/28
     */
    public AppResponse updateMenuBtn(MenuBtn menuBtn) {
        AppResponse appResponse = AppResponse.success("修改成功！");
        int count = menuBtnDao.updateMenuBtn(menuBtn);
        if(0 == count) {
            appResponse = AppResponse.bizError("修改失败！");
        }
        return appResponse;
    }
}
