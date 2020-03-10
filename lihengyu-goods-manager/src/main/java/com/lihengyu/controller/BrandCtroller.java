package com.lihengyu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lihengyu.pojo.Brand;
import com.lihengyu.pojo.Spec;
import com.lihengyu.service.BrandService;


/**
 * 品牌管理
 * @author zhuzg
 *
 */
@Controller
@RequestMapping("brand")
public class BrandCtroller {
	
	@Reference
	BrandService brandService;
	
	@RequestMapping("list")
	public String list(HttpServletRequest request,@RequestParam(defaultValue="1") int page) {
		PageInfo<Brand> pageInfo = brandService.select(page);
		request.setAttribute("pageInfo",pageInfo);
		return "brand/list";
	}
	
	@RequestMapping("add")
	@ResponseBody
	public Object add(HttpServletRequest request,Brand brand
	) {
		int add = brandService.addBrand(brand);
		return add>0?"true":"false";
	}
	
	@RequestMapping("update")
	@ResponseBody
	public String update(HttpServletRequest request,Brand brand
	) {
		int result = brandService.updateBrand(brand);
		return result >0 ?"success":"false";
	}
	
	@RequestMapping("toUpdate")
	@ResponseBody
	public Brand toUpdate(HttpServletRequest request,int id
	) {
		return brandService.toUpdateBrand(id);
	}
	
	@RequestMapping("del")
	@ResponseBody
	public String delSpec(HttpServletRequest request,int id) {
		//调用服务
		int delNum = brandService.deleteBrand(id);
		return delNum>0?"success":"false";
	}

}
