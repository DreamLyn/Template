package com.lyn.modules.menu.entity;


import com.lyn.modules.user.bean.Gender;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Menu {
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
     * 是否有用
     */
    private int used;
    /**
     * 对应层级
     */
    private int level;
    /**
     * 显示顺序
     */
    private int showOrder;
    /**
     * 显示图标
     */
    private String icon;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
}
