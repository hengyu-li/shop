package com.lihengyu.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.lihengyu.config.AdminProperties;
import com.lihengyu.service.UserService;
@Service(interfaceClass = UserService.class,version = "1.0.0")
public class UserServiceImpl implements UserService {

	@Autowired
	AdminProperties adminPro;
	
	public boolean login(String userName, String passWord) {
				//判断用户和密码是否与配置文件一致
				return (adminPro.getAdminName().equals(userName) 
						&& adminPro.getPassword().equals(passWord));
	}

}
