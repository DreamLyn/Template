package com.lyn.modules.business.service;

import com.lyn.modules.business.dao.MenuRepository;
import com.lyn.modules.business.entity.Business;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Business> getAllMenu() {
        return menuRepository.findAll();
    }

    /**
     * 根据父id获取菜单
     * @param parendId
     * @return
     */
    public List<Business> getMenu(long parendId) {
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
     * @param business
     * @return
     */
    public Business saveMenu(Business business){
        return menuRepository.save(business);
    }



}
