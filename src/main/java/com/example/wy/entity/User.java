package com.example.wy.entity;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public class User {
    /**
     *  id
     */
    private Integer id;

    /**
     *  username
     */
    private String username;

    /**
     *  password
     */
    private String password;

    /**
     *  enabled
     */
    private Boolean enabled;

    /**
     *  locked
     */
    private Boolean locked;

    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    /**
     *
     * @author wuyang
     * @date 2019-08-18 15:33:03
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @author wuyang
     * @date 2019-08-18 15:33:03
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @author wuyang
     * @date 2019-08-18 15:33:03
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @author wuyang
     * @date 2019-08-18 15:33:03
     * @param username
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     *
     * @author wuyang
     * @date 2019-08-18 15:33:03
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @author wuyang
     * @date 2019-08-18 15:33:03
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     *
     * @author wuyang
     * @date 2019-08-18 15:33:03
     * @return enabled
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     *
     * @author wuyang
     * @date 2019-08-18 15:33:03
     * @param enabled
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     *
     * @author wuyang
     * @date 2019-08-18 15:33:03
     * @return locked
     */
    public Boolean getLocked() {
        return locked;
    }

    /**
     *
     * @author wuyang
     * @date 2019-08-18 15:33:03
     * @param locked
     */
    public void setLocked(Boolean locked) {
        this.locked = locked;
    }



}