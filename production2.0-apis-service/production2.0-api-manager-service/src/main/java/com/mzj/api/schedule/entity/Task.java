package com.mzj.api.schedule.entity;

import lombok.Data;

@Data
public class Task {
	private String taskId;

	private String manufactureSn;

	private String workId;

	private Integer taskQuantity;

	private Long workingHours;

}