package com.mzj.api.entity.authority;

import java.util.List;

import com.mzj.api.entity.customize.ActiveUser;

import lombok.Data;

@Data
public class SysPermission {
    private Long id;

    private String name;

    private String type;

    private String url;

    private String percode;

    private Long parentid;

    private String parentids;

    private String sortstring;

    private String available;

}