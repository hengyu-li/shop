package com.lihengyu.dao;

import java.util.List;

import com.lihengyu.pojo.Category;

/**
 * 
 * @author zhuzg
 *
 */
public interface CategoryDao {

	 List<Category> tree();

	int add(Category category);

	/**
	 * 
	 * @param id
	 * @return
	 */
	int delete(Integer id);

	/**
	 * 修改
	 * @param category
	 * @return
	 */
	int update(Category category);
}
