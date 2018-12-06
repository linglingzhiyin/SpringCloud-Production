package com.mzj.api.technology.service;

import java.util.List;

import com.mzj.api.technology.entity.Technology;
import com.mzj.api.technology.entity.TechnologyRequirement;

public interface TechnologyRequirementService {

	List<Technology> find() ;

	TechnologyRequirement get(String string) ;

}
