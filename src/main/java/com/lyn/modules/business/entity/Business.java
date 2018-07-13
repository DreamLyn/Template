package com.lyn.modules.business.entity;


import com.lyn.modules.audit.AbstractAuditable;
import com.lyn.modules.local.entity.AreaInfo;
import com.lyn.modules.oss.entity.Oss;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 业务表
 */
@Data
@Entity
public class Business extends AbstractAuditable {
    /**
     * 业务名
     */
    private String name;
    /**
     * 业务类型,暂定 1 标准业务(三流程) 2 artable图片显示 3 视频
     */
    @Column(columnDefinition = "tinyint")
    private Integer type;


    /**
     * 此项业务所对应的地域(税局),一项业务只能属于一个地域.  有时候需要根据税局去获取所属地域,,可能还需要从所属地域获取业务信息
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "area_id")
    private AreaInfo areaInfo;

    @ManyToMany
    @JoinTable(name = "business_oss",
            joinColumns = @JoinColumn(name = "business_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "oss_id", referencedColumnName = "id"))
    private List<Oss> osss = new ArrayList<>();
}
