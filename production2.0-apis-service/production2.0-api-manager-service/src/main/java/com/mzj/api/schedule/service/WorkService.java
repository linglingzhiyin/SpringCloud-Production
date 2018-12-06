package com.mzj.api.schedule.service;

import java.util.List;

import com.mzj.api.schedule.entity.Work;

public interface WorkService {

	List<Work> find() throws Exception;

	Work get(String string) throws Exception;
}
