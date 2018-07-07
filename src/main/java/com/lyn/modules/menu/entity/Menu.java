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
    private long platformId;
    private long parentId;
    private String muduleName;
    private String url;
    private int type;
    private String modulePath;
    private int used;
    private int level;
    private int showorder;
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
}
