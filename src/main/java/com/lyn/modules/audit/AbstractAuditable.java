package com.lyn.modules.audit;


import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditable {

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(name = "create_time",nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;


    @CreatedBy
    @Column(name = "create_user_id",nullable = true)
    private Long createUserId;


    @LastModifiedDate
    @Column(name = "last_modified_time",nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedTime;

    @LastModifiedBy
    @Column(name = "last_modified_user_id",nullable = true)
    private Long lastModifiedUserId;
}
