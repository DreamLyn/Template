package com.lyn.modules.local.entity;

import com.lyn.modules.audit.AbstractAuditable;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Data
@Entity
public class AreaInfo extends AbstractAuditable {
    /**
     * 地域名称
     */
    @Column(length = 50)
    private String name;

    /**
     * 地域等级 1 省份  2 市  3 税局
     */
    @Column(columnDefinition = "tinyint")
    private Integer areaLevel;
    /**
     * 父ID
     */
    private Long parentId;

    @Column(columnDefinition = "tinyint")
    private Integer sort;
}