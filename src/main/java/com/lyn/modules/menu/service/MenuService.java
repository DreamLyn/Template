package com.lyn.modules.menu.service;

import com.lyn.modules.menu.dao.MenuRepository;
import com.lyn.modules.menu.entity.Menu;
import com.lyn.modules.user.dao.UserRepository;
import com.lyn.modules.user.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;


    /**
     * 获取所有menu
     *
     * @return
     */
    public List<Menu> getAllMenu() {
        return menuRepository.findAll();
    }

    /**
     * 根据父id获取菜单
     * @param parendId
     * @return
     */
    public List<Menu> getMenu(long parendId) {
        return menuRepository.findAllByParentId(parendId);
    }

    /**
     * 根据父id删除菜单
     * @param id
     * @return
     */
    public void delMenu(long id) {
        menuRepository.deleteById(id);
    }

    /**
     * 批量删除
     * @param ids
     */
    public void delMenus(List<Long> ids) {
        menuRepository.deleteByIds(ids);
    }
    /**
     * 更新
     * @param menu
     * @return
     */
    public Menu saveMenu(Menu menu){
        return menuRepository.save(menu);
    }



}
