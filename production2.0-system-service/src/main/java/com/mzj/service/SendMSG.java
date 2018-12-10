package com.mzj.service;

import com.mzj.api.service.ISendMSG;

public class SendMSG implements ISendMSG {

	@Override
	public String ISendMSG() {
		System.out.println("发送消息成功");
		return null;
	}

}
