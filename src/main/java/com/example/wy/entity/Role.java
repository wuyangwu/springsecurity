package com.example.wy.entity;

public class Role {
    /**
     *  id
     */
    private Integer id;

    /**
     *  name
     */
    private String name;

    /**
     *  nameZh
     */
    private String namezh;

    /**
     * 
     * @author wuyang
     * @date 2019-08-18 16:57:27
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @author wuyang
     * @date 2019-08-18 16:57:27
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @author wuyang
     * @date 2019-08-18 16:57:27
     * @return name 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @author wuyang
     * @date 2019-08-18 16:57:27
     * @param name 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 
     * @author wuyang
     * @date 2019-08-18 16:57:27
     * @return nameZh 
     */
    public String getNamezh() {
        return namezh;
    }

    /**
     * 
     * @author wuyang
     * @date 2019-08-18 16:57:27
     * @param namezh 
     */
    public void setNamezh(String namezh) {
        this.namezh = namezh == null ? null : namezh.trim();
    }
}