package com.lyn.modules.dict.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Dict {
    @Id
    @GeneratedValue
    private long id;
    /**
     * 父ID
     */
    private long parentId;
    /**
     * 模块名
     */
    private String label;
    /**
     * 对应路径
     */
    private String path;
    /**
     * 对应组件
     */
    private String component;
    /**
     * 对应类型,后期有用,是按钮还是菜单 目前统一为0,菜单
     */
    private int type;
    /**
     * 模块深度路径值
     */
    private String modulePath;
    /**
     * 状态 0 无效 1有效
     */
    @Column(name="status",columnDefinition="tinyint default 1")
    private int status;
    /**
     * 对应层级
     */
    private int level;
    /**
     * 显示顺序
     */
    private int sort;
    /**
     * 显示图标
     */
    private String icon;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
}
