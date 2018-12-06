package com.mzj.api.schedule.entity;

import java.util.Date;


import lombok.Data;
@Data
public class Manufacture {

    private String manufactureSn;

    private Integer launchQuantity;
	
    private Date beginDate;

    private Date endDate;

    private String orderId;

    private String technologyId;
    
}