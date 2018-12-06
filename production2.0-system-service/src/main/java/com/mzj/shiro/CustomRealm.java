package com.mzj.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.mzj.api.entity.authority.SysPermission;
import com.mzj.api.entity.authority.SysRole;
import com.mzj.api.entity.authority.SysUser;
import com.mzj.api.entity.customize.ActiveUser;
import com.mzj.mapper.SysUserMapper;
import com.mzj.service.RoleService;
import com.mzj.service.SysService;

/**
 * created on 2016年9月6日
 *
 * 自定义shiro realm
 *
 * @author megagao
 * @version 0.0.1
 */
public class CustomRealm extends AuthorizingRealm {

	@Autowired
	private SysService sysService;

	@Autowired
	private RoleService roleService;


	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 从 principals获取主身份信息
		// 将getPrimaryPrincipal方法返回值转为真实身份类型（在上边的doGetAuthenticationInfo认证通过填充到SimpleAuthenticationInfo中身份类型），
		ActiveUser activeUser = (ActiveUser) principals.getPrimaryPrincipal();

		// 根据身份信息从数据库获取到权限数据
		List<SysPermission> permissionList = sysService.findPermissionListByUserId(activeUser.getUserid());

		List<String> permissions = new ArrayList<String>();
		if (permissionList != null) {
			for (SysPermission sysPermission : permissionList) {
				permissions.add(sysPermission.getPercode());
			}
		}

		// 查到权限数据，返回授权信息(要包括 上边的permissions)
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		// 将上边查询到授权信息填充到simpleAuthorizationInfo对象中
		simpleAuthorizationInfo.addStringPermissions(permissions);

		return simpleAuthorizationInfo;

	}

	/**
	 * realm的认证方法，从数据库查询用户信息
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// token是用户输入的用户名和密码,第一步从token中取出用户名
		String username = (String) token.getPrincipal();

		// 第二步：根据用户输入的username从数据库查询
		SysUser sysUser = sysService.getSysUserByName(username);
		// 如果查询不到返回null
		if (sysUser == null)
			return null;

		String password = sysUser.getPassword();

		// 如果查询到返回认证信息AuthenticationInfo
		// activeUser就是用户身份信息
		ActiveUser activeUser = new ActiveUser();

		activeUser.setUserid(sysUser.getId());
		activeUser.setUsername(sysUser.getUsername());
		activeUser.setUserStatus(sysUser.getLocked());

		SysRole sysRole = null;
		List<SysRole> srs = roleService.findRoleByUserId(sysUser.getId());
		if (srs != null)
			sysRole = srs.get(0);
		if (sysRole != null) {
			activeUser.setRolename(sysRole.getRoleName());
			activeUser.setRoleStatus(sysRole.getAvailable());

		}

		// 根据用户id取出菜单
		List<SysPermission> menus = sysService.findMenuListByUserId(sysUser.getId());

		// 将用户菜单设置到activeUser
		activeUser.setMenus(menus);

		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(activeUser, password,
				"CustomRealm");

		return simpleAuthenticationInfo;
	}

	// 清除缓存
	public void clearCached() {
		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
		super.clearCache(principals);
	}

}
