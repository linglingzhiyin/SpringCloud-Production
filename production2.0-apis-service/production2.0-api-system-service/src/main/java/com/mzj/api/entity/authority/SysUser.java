package com.mzj.api.entity.authority;

import lombok.Data;

@Data
public class SysUser {
	
	private String id;

    private String username;

    private String password;
    
    private String locked;
    

}
