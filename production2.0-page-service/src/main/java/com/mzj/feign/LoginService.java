package com.mzj.feign;

import org.springframework.cloud.openfeign.FeignClient;

import com.mzj.api.service.ILoginService;

@FeignClient("production-system")
public interface LoginService extends ILoginService{
	
}
