package com.yc.spring.bbsb.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yc.spring.bbs.bean.User;
import com.yc.spring.bbsb.dao.UserDao;

// Spring 的组件注解 ==》Bean 标签
public class UserBiz {

	//需要从容器中获取UserDao
	private UserDao uDao;

	public void create(User user) throws InterruptedException {
		Thread.sleep(200);
		uDao.insert(user);
	}

	public void modify(User user) {
		uDao.update(user);
	}

	public void remove(User user) throws InterruptedException {
		Thread.sleep(300);
		uDao.delete(user);
	}

	public UserDao getuDao() {
		return uDao;
	}
	public void setuDao(UserDao uDao) {
		this.uDao = uDao;
	}
	
}
