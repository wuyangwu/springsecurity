package com.example.wy.entity;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author wuyang
 * @version 1.0
 * @date 2019/8/20 9:26
 */
public class Users implements UserDetails {
    private Integer id;
    private String username;
    @JsonIgnore
    private String password;
    private Boolean enabled;
    private Boolean locked;
    private List<Role> roles;
    private JSONArray menus;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //获取用户权限
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for(Role role: roles){
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public JSONArray getMenus() {
        return menus;
    }

    public void setMenus(JSONArray menus) {
        this.menus = menus;
    }
}
