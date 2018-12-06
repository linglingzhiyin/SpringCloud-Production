package com.mzj.api.schedule.service;

import java.util.List;

import com.mzj.api.schedule.entity.Manufacture;

public interface ManufactureService {

	List<Manufacture> find() throws Exception;

	Manufacture get(String string) throws Exception;
}
