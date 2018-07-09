package com.lyn.modules.business.dao;

import com.lyn.modules.business.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface MenuRepository extends JpaRepository<Business, Long>{
    /**
     * 根据父ID查找菜单
     * @param parentId
     * @return
     */
    List<Business> findAllByParentId(long parentId);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @Modifying
    @Transactional
    @Query(value="delete from Business m where m.id in (:ids) ")
    int deleteByIds(@Param("ids") List<Long> ids);

}
