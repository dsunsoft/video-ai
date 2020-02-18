package com.dsunsoft.module.admin.dto;

import com.dsunsoft.core.entity.BaseSearchDto;

import lombok.Data;

@Data
public class SysRoleSearchDto extends BaseSearchDto{

    /**
     * 
     */
    private static final long serialVersionUID = 4066090064766848428L;
    
    /**
     * 角色名称
     */
    private String roleName;
}
