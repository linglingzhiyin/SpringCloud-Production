package com.mzj.api.schedule.service;

import java.util.List;

import com.mzj.api.schedule.entity.COrder;

public interface OrderService {
	List<COrder> find();

	COrder get(String string);

}
