package com.lyn.modules.dict.dao;

import com.lyn.modules.dict.entity.Dict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface DictRepository extends JpaRepository<Dict, Long>{
    /**
     * 根据父ID查找菜单
     * @param parentId
     * @return
     */
    List<Dict> findAllByParentId(long parentId);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @Modifying
    @Transactional
    @Query(value="delete from Dict m where m.id in (:ids) ")
    int deleteByIds(@Param("ids") List<Long> ids);

}
