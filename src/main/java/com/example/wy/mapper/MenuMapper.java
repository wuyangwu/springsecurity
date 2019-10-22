package com.example.wy.mapper;

import com.example.wy.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {

    public List<Menu> getAll();

    // 通过用户id查找权限后通过权限查找菜单menu
    public List<Menu> getRoleOrMenu(String username);

}
