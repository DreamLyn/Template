package com.lyn.modules.oss.dao;

import com.lyn.modules.dict.entity.Dict;
import com.lyn.modules.oss.entity.Oss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface OssRepository extends JpaRepository<Oss, Long>{
    /**
     * 查找OSS
     * @param id
     * @return
     */
    List<Oss> findById(long id);

}
