package com.mzj.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mzj.Util.EmailUtil;
import com.mzj.Util.SendMessageUtil;
import com.mzj.api.entity.authority.SysUser;
import com.mzj.api.service.IRegisterService;
import com.mzj.mapper.SysUserMapper;

public class RegisterService implements IRegisterService {
	@Autowired
	private EmailUtil emailUtil;

	@Autowired
	SysUserMapper sysUserMapper;

	@Override
	public String register(String username, String password, String phone, String email) {
		emailUtil.sendEmail("mzj2610@163.com", "171490422@qq.com", "sendSimpleMailTest", "hello");
		// SendMessageUtil.send("SMS账户","接口秘钥","目标号码","发送内容");
		SendMessageUtil.send("mzj2610", "d41d8cd98f00b204e980", "14726084230",
				"验证码:" + SendMessageUtil.getRandomCode(6));

		SysUser user = new SysUser();
		user.setUsername(username);
		user.setPassword(password);
		sysUserMapper.insert(user);

		return "注册成功";
	}

}
