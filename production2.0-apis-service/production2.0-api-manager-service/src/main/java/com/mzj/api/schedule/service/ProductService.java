package com.mzj.api.schedule.service;

import java.util.List;

import com.mzj.api.schedule.entity.Product;

public interface ProductService {

	List<Product> find();

	Product get(String string) throws Exception;
}
