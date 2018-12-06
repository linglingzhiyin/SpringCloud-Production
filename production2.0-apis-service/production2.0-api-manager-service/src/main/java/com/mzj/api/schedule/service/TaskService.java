package com.mzj.api.schedule.service;

import java.util.List;

import com.mzj.api.schedule.entity.Task;


public interface TaskService {
	
	List<Task> find() ;
	
	Task get(String string);
	
}
