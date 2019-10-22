package com.example.wy.entity;

import java.util.Date;

/**
 * @author wuyang
 * @version 1.0
 * @date 2019/10/19 14:29
 */
public class Menu {
    private int id;
    private int pid;
    private int isparent;
    private String name;
    private String path;
    private String icon;
    private String delflag;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getIsparent() {
        return isparent;
    }

    public void setIsparent(int isparent) {
        this.isparent = isparent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDeflag() {
        return delflag;
    }

    public void setDeflag(String delflag) {
        this.delflag = delflag;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", pid=" + pid +
                ", isparent=" + isparent +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", icon='" + icon + '\'' +
                ", delflag='" + delflag + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
