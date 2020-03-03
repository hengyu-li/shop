package com.lihengyu.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lihengyu.pojo.Brand;
import com.lihengyu.pojo.Category;

public interface GoodsService {
	
	int addBrand(Brand brand);
	int updateBrand(Brand Brand);
	int deleteBrand(Integer id);
	/**
	 * 
	 * @param firstChar 首字母
	 * @param page 页码
	 * @return
	 */
	PageInfo<Brand> listBrand(String firstChar,int page);
	
	int addCategory(Category category);
	int updateCategory(Category category);
	int deleteCategory(Integer id);
	/**
	 * 
	 * @param firstChar 首字母
	 * @param page 页码
	 * @return
	 */
	PageInfo<Category> listCategory(String firstChar,int page);
	
	List<Category> treeCategory();
}
