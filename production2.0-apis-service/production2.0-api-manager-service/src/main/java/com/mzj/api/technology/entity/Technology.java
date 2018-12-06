package com.mzj.api.technology.entity;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import lombok.Data;
@Data
public class Technology {
	
    private String technologyId;

    private String technologyName;

    private BigDecimal price;

    private String vitalProcessPeriod;

    private Integer standardCapacity;

    private Integer overtimeStandardCapacity;

    private Integer overtimeOverfulfilCapacity;

    private Integer doubleCapacity;

    private Integer overfulfilCapacity;

}