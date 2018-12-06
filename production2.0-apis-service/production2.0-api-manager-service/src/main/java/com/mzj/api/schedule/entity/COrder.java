package com.mzj.api.schedule.entity;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
@Data
public class COrder {
	private String orderId;

	private Date orderDate;

	private Date requestDate;

	private String note;
	
	private Integer quantity;

	private BigDecimal unitPrice;

	private String unit;

	private String image;

	private String file;

	private Integer status;

	private String customId;

	private String productId;

}