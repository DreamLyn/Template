package com.lyn.modules.menu.controller;

import com.lyn.modules.common.data.STATUS;
import com.lyn.modules.common.schema.Result;
import com.lyn.modules.menu.entity.Menu;
import com.lyn.modules.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 获取所有菜单,应根据用户所属角色的权限获取相应的菜单项,后期考虑
     *
     * @return
     */
    @PostMapping("/get/all")
    public Result getAllMenu() {
        Result result = new Result();
        List<Menu> menus = menuService.getAllMenu();
        result.setCode(STATUS.SUCCESS);
        result.setData(menus);
        return result;
    }

    /**
     * 根据id获取其子菜单
     *
     * @param id
     * @return
     */
    @PostMapping("/get/{id}")
    public Result getNodeMenu(@PathVariable("id") long id) {
        Result result = new Result();
        List<Menu> menus = menuService.getNodeMenu(id);
        result.setCode(STATUS.SUCCESS);
        result.setData(menus);
        return result;
    }

    /**
     * 修改
     * @param menu
     * @return
     */
    @PostMapping("/save")
    public Result updateMenu(@RequestBody Menu menu) {
        Result result=new Result();
        result.setCode(STATUS.SUCCESS);
        result.setData(menuService.saveMenu(menu));
        return result;
    }


}
