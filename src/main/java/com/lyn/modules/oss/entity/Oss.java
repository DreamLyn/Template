package com.lyn.modules.oss.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Oss {
    @Id
    @GeneratedValue
    private long id;
    private String url;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
}
