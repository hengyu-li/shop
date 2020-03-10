package com.lihengyu.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lihengyu.dao.BrandDao;
import com.lihengyu.pojo.Brand;
import com.lihengyu.service.BrandService;

@Service(interfaceClass = BrandService.class)
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	BrandDao brandDao;

	public PageInfo<Brand> select(int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page,5);
		return new PageInfo<Brand>(brandDao.select());
	}

	public int addBrand(Brand brand) {
		// TODO Auto-generated method stub
		return brandDao.addBrand(brand);
	}

	public int updateBrand(Brand brand) {
		// TODO Auto-generated method stub
		return brandDao.updateBrand(brand);
	}

	public int deleteBrand(int id) {
		// TODO Auto-generated method stub
		return brandDao.deleteBrand(id);
	}

	public Brand toUpdateBrand(int id) {
		// TODO Auto-generated method stub
		return brandDao.toUpdate(id);
	}

}
