package com.mzj.api.entity.vo;

import lombok.Data;

@Data
public class UserVO {
	
    private String id;

    private String username;

    private String password;

    private String locked;

    private String roleName;

    private String roleId;

}