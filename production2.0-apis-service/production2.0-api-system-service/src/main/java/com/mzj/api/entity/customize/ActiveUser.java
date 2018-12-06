package com.mzj.api.entity.customize;

import java.util.List;
import com.mzj.api.entity.authority.SysPermission;

import lombok.Data;

@Data
public class ActiveUser implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String userid;//用户id（主键）
	private String username;// 用户名称
	private String userStatus;// 用户状�??
	private String rolename;// 角色名称
	private String roleStatus;// 角色状�??
	private List<SysPermission> menus;// 菜单
	private List<SysPermission> permissions;// 权限

}
