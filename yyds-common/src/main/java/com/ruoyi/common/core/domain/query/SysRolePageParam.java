package com.ruoyi.common.core.domain.query;

import lombok.Data;

@Data
public class SysRolePageParam{
    /**
     * 排序的列字段
     */
    private String column;

    /**
     * 排序规则默认降序 降序:false 升序:true
     */
    private Boolean asc;



    public Boolean getAsc() {
        return asc == null ? false : asc;
    }


}
