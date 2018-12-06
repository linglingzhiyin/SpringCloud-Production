package com.mzj.api.technology.service;

import java.util.List;

import com.mzj.api.technology.entity.Technology;

public interface TechnologyService {

	List<Technology> find();

	Technology get(String string);
}
