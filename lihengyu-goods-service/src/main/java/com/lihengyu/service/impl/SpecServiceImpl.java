package com.lihengyu.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.lihengyu.dao.SpecDao;
import com.lihengyu.pojo.Spec;
import com.lihengyu.pojo.SpecOption;
import com.lihengyu.service.SpecService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 规格的管理
 * @author zhuzg
 *
 */
@Service(interfaceClass=SpecService.class)
public class SpecServiceImpl implements SpecService{
	
	@Autowired
	SpecDao specDao;

	public PageInfo<Spec> list(String name, int page) {
		PageHelper.startPage(page, 3);
		return new PageInfo<Spec>(specDao.list(name));
	}

	public int add(Spec spec) {
		// TODO Auto-generated method stub
				//添加主表
				specDao.addSpec(spec);
				// 这里才能获取到主键ID
				//添加子表
				List<SpecOption> options = spec.getOptions();
				//
				int n=1;
				for (SpecOption specOption : options) {
					// 设置主表的id
					specOption.setSpecId(spec.getId());
					specDao.addOption(specOption);
					n++;
				}
				
				// 返回的是影响数据的条数
				return n;
	}

	public int update(Spec spec) {
		// TODO Auto-generated method stub
		return specDao.updateSpec(spec);
	}

	public int delete(int id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				//删除子表
				specDao.deleteSpecOtions(id);
				//删除主表
				specDao.deleteSpec(id);
				return 1;
	}

	public Spec findById(int id) {
		// TODO Auto-generated method stub
		return specDao.get(id);
	}

	public int deleteBatch(int[] ids) {
				//删除子表
				specDao.deleteSpecOtionsBatch(ids);
				//删除主表
				specDao.deleteSpecBatch(ids);
				return 1;
	}

	public List<Spec> listAll() {
		// TODO Auto-generated method stub
		return specDao.listAll();
	}

	
	
	

}
