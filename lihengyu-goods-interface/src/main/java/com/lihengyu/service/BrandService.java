package com.lihengyu.service;

import com.github.pagehelper.PageInfo;
import com.lihengyu.pojo.Brand;

public interface BrandService {
	
	PageInfo<Brand> select(int page); 
	
	int addBrand(Brand brand);
	
	int updateBrand(Brand brand);
	
	int deleteBrand(int id);
	
	Brand toUpdateBrand(int id);

}
