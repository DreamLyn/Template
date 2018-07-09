package com.lyn.modules.menu.dao;

import com.lyn.modules.menu.entity.Menu;
import com.lyn.modules.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long>{
    /**
     * 根据父ID查找菜单
     * @param parentId
     * @return
     */
    List<Menu> findAllByParentId(long parentId);
}
