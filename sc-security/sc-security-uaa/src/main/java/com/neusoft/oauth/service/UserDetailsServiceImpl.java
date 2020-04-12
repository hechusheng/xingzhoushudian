package com.neusoft.oauth.service;

import com.neusoft.oauth.dao.SysUserDao;
import com.neusoft.oauth.entity.SysUser;
import com.neusoft.security.core.entity.SecurityUser;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>UserDetailsService实现类</p>
 * <p>创建日期：2017-12-27</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private SysUserDao sysUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String lowCaseUsername = username.toLowerCase();
        SysUser sysUser = sysUserDao.getUserInfoByUsername(lowCaseUsername);
        if (sysUser != null) {
            return new SecurityUser(sysUser.getId(), sysUser.getAccount(), sysUser.getName(), sysUser.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("web,app"));
        }
        throw new UsernameNotFoundException("用户" + lowCaseUsername + "不存在!");
    }

}
