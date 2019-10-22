package com.example.wy.web.service;

import com.alibaba.fastjson.JSONArray;
import com.example.wy.entity.Menu;
import com.example.wy.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import java.util.List;

/**
 * @author wuyang
 * @version 1.0
 * @date 2019/10/20 17:44
 */
@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;


    public JSONArray  getRolerorMenu(String username){
       List<Menu> menus = menuMapper.getRoleOrMenu(username);
        JSONArray jsonArray = new JSONArray();
        this.Recursive(menus, jsonArray);
       return jsonArray;
    }

    public void Recursive(List<Menu> menus, JSONArray jsonArray){

        for(int i = 0 ; i < menus.size(); i ++){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("path", menus.get(i).getName());
            jsonObject.put("name",menus.get(i).getPath());
            jsonObject.put("icon", menus.get(i).getIcon());
            if(menus.get(i).getIsparent() == 1) {
               jsonObject.put("children",this.Recursives(menus, menus.get(i).getId()));
            }
            if(menus.get(i).getPid() != 0){
                break;
            }else {
                jsonArray.add(jsonObject);
            }
        }
    }

    public JSONArray Recursives(List<Menu> menus, int pid){
        JSONArray jsonArray = new JSONArray();
        for(Menu menu: menus){
            JSONObject jsonObject1 = new JSONObject();
            // 子节点比较
            if(pid == menu.getPid()){
                jsonObject1.put("path",menu.getName());
                jsonObject1.put("name",menu.getPath());
                jsonObject1.put("icon", menu.getIcon());
                if(menu.getIsparent() == 1){
                    // 子菜单查找
                    jsonObject1.put("children",Recursives(menus,menu.getId()));
                }
                jsonArray.add(jsonObject1);
            }
        }
        return jsonArray;
    }


}
