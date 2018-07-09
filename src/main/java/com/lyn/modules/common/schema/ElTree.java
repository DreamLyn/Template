package com.lyn.modules.common.schema;

import lombok.Data;

import java.util.List;

@Data
public class ElTree {
    /**
     * id
     */
    private long id;
    /**
     * 父ID
     */
    private long parentId;
    /**
     * 模块名
     */
    private String label;

    private List<ElTree> children;
}
