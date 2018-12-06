package com.mzj.api.schedule.service;

import java.util.List;

import com.mzj.api.schedule.entity.Custom;

public interface CustomService {

	List<Custom> find();

	Custom get(String string);
}
