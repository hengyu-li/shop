package com.lihengyu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.lihengyu.pojo.Brand;

public interface BrandDao {

	/**
	 * 获取所有的品牌
	 * @return
	 */
	@Select("SELECT id,name,first_char as firstChar "
			+ " FROM hg_brand "
			+ "where deleted_flag=0"
			+ " ORDER BY name ")
	List<Brand> listAll();
	
	List<Brand> select();
	
	int addBrand(Brand brand);
	
	int updateBrand(Brand brand);
	
	int deleteBrand(int id);
	
	Brand toUpdate(int id);

}
