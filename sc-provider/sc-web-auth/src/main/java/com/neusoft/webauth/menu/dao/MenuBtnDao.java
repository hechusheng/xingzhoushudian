package com.neusoft.webauth.menu.dao;

import com.neusoft.webauth.menu.entity.MenuBtn;

import java.util.List;
import java.util.Map;

/**
 * @ClassName MenuBtnDao
 * @Description 菜单管理
 * @Author zhu.qf@neusoft.com
 * @Date 2018/11/28
 */
public interface MenuBtnDao {
    /**
     * 获取菜单下的按钮
     * @param menuCode 菜单代码
     * @return
     */
    List<MenuBtn> listMenuBtns(String menuCode);

    /**
     * 删除菜单按钮
     * @param menuBtn 菜单按钮信息
     * @return
     */
    int deleteMenuBtn(MenuBtn menuBtn);

    /**
     * 删除角色菜单按钮关联关系
     * @param menuBtn
     * @return
     */
    int deleteRoleMenuBtnBy(MenuBtn menuBtn);

    String getParentAuthCode(MenuBtn menuBtn);

    /**
     * 新增菜单按钮
     * @param menuBtn 菜单按钮信息
     * @return
     */
    int insertMenuBtn(MenuBtn menuBtn);

    /**
     * 修改菜单按钮
     * @param menuBtn
     * @return
     */
    int updateMenuBtn(MenuBtn menuBtn);

    /**
     * 获取角色授权的菜单按钮
     * @param menuBtn 菜单按钮信息
     * @return
     */
    List<MenuBtn> listRoleMenuBtns(MenuBtn menuBtn);

    String[] getMenuList(Map<String, Object> params);

    void delRoleMenuBtn(MenuBtn obj);

    /**
     * 角色管理-菜单授权，新增角色菜单按钮
     * @param list
     * @return
     */
    int insertRoleMenuBtn(List<MenuBtn> list);

    /**
     * 角色管理-菜单授权，删除角色菜单按钮
     * @param map 角色菜单信息
     * @return
     */
    int deleteRoleMenuBtns(Map<String, Object> map);

}
