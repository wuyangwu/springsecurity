package com.example.wy.web.service;

import com.example.wy.entity.User;
import com.example.wy.entity.Users;
import com.example.wy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import javax.xml.ws.ServiceMode;

/**
 * @author wuyang
 * @version 1.0
 * @date 2019/8/18 17:10
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuService menuService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userMapper.loadUserByUsername(username);
       if (user == null){
           System.out.println("账户不存在");
           throw new UsernameNotFoundException("账户不存在");
       }
        Users users = new Users();
       users.setEnabled(user.getEnabled());
       users.setId(user.getId());
       users.setUsername(username);
       // 这个里面又判断密码的
       users.setPassword(user.getPassword());
       users.setLocked(user.getLocked());
       users.setMenus(menuService.getRolerorMenu(username));
       users.setRoles(userMapper.getUserRolesByUid(user.getId()));
       return users;
//       return user;
    }
}
