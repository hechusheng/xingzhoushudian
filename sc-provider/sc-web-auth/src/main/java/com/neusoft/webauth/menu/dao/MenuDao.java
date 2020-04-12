package com.neusoft.webauth.menu.dao;

import com.neusoft.webauth.menu.entity.Menu;

import java.util.List;

/**
 * @ClassName MenuDao
 * @Description 菜单管理
 * @Author zhu.qf@neusoft.com
 * @Date 2018/11/28
 */
public interface MenuDao {

    /**
     * 查询全部菜单
     * @return 菜单集合
     */
    List<Menu> listMenus();

    /**
     * 删除角色关联菜单
     * @param menu 菜单信息
     * @return
     */
    int deleteRoleMenu(Menu menu);

//    void deleteAdditionMenu(String[] menuId);

    /**
     * 删除菜单
     * @param menu 菜单信息
     * @return
     */
    int deleteMenu(Menu menu);

    int isExitChildMenu(Menu menu);

    int updateParentType(Menu menu);

    String getMaxChildrenSORT_NO(String parentMenuCode);

    /**
     * 获取菜单范围代码
     * @param menu 菜单信息
     * @return
     */
    String getAuthCode(Menu menu);

    /**
     * 新增菜单
     * @param menu 菜单信息
     * @return
     */
    int insertMenu(Menu menu);

    /**
     * 修改菜单
     * @param menu 菜单信息
     * @return
     */
    int updateMenu(Menu menu);

    /**
     * 根据角色代码查询已授权的菜单代码
     * @param roleCode 角色代码
     * @return 菜单代码集合
     */
    List<Menu> listRoleMenusBy(String roleCode);

    /**
     * 获取用户菜单信息
     * @param menu
     * @return
     */
    List<Menu> listUserMenus(Menu menu);

    /**
     * 删除角色关联的菜单按钮
     * @param menu 菜单信息
     * @return
     */
    int deleteRoleMenuBtnByMenu(Menu menu);
}
