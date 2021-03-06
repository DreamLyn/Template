package com.lyn.modules.menu.dao;

import com.lyn.modules.menu.entity.Menu;
import com.lyn.modules.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long>{
    /**
     * 根据父ID查找菜单
     * @param parentId
     * @return
     */
    List<Menu> findAllByParentId(long parentId);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @Modifying
    @Transactional
    @Query(value="delete from Menu m where m.id in (:ids) ")
    int deleteByIds(@Param("ids")List<Long> ids);

}
