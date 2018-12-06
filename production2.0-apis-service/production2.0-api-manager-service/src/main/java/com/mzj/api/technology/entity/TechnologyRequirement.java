package com.mzj.api.technology.entity;

import java.util.Date;

import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class TechnologyRequirement {
	private String technologyRequirementId;

	private String technologyId;

	private String requirement;

	private Date addTime;

	private Date reviseTime;

}