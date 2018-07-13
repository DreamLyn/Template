package com.lyn.modules.oss.entity;

import com.lyn.modules.audit.AbstractAuditable;
import com.lyn.modules.business.entity.Business;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Oss extends AbstractAuditable{

    private String url;

    @ManyToMany(mappedBy = "osss")
    private List<Business> businesss=new ArrayList<>();
}
