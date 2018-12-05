package com.mzj.api.entity.authority;

import lombok.Data;

@Data
public class SysRolePermission {
    private String id;

    private String sysRoleId;

    private String sysPermissionId;

}