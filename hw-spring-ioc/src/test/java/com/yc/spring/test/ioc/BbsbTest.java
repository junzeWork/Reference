package com.yc.spring.test.ioc;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.yc.spring.bbsb.biz.UserBiz;
import com.yc.spring.bbsb.dao.UserDao;

@RunWith(SpringRunner.class)
@ContextConfiguration("/bbsb-aop.xml")
public class BbsbTest {
	
	@Resource
	private UserBiz userBiz;
	
	@Autowired
	private UserDao userDao;
	@Test
	public void test() throws Exception{
		userBiz.create(null);
		userBiz.remove(null);
		System.out.println(userBiz.getuDao()+"--");
		
		userDao.insert(null);
		userDao.selectOne(null);
		userDao.selectList(null, null, null);
		userDao.update(null);
		System.out.println(userDao+"---");
	}
}
