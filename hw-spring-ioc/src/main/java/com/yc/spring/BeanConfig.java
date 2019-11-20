package com.yc.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.yc.spring.bank.bean.Account;
import com.yc.spring.bbs.bean.User;
import com.yc.spring.bbs.biz.UserBiz;

//包扫描  扫描所有加了组件注解的类  并且将该类对象放入Spring容器中
@ComponentScan("com.yc.spring")
@Configuration
public class BeanConfig {

	// <bean> ==>@Bean
	@Bean(name="account")
	@Primary
	public Account getAccount() {
		return new Account();
	}
	
	@Bean(name="account1")
	@Scope("prototype")
	public Account getAccount1() {
		return new Account();
	}
	
	@Bean(name="account2")
	public Account getAccount2() {
		return Account.getInstance();
	}
	
	@Bean(name="account3")
	public Account getAccount3() {
		return Account.getInstance();
	}
	
	int count;
	@Bean(name="account4")
	@Scope("prototype")
	public Account getAccount4() {
		return count++ < 3 ? new Account() : Account.getInstance();
	}
	
	@Bean(name="myUser")
	public User getUser() {
		User user=new User();
		user.setUname("武松");
		user.setUpass("abc123");
		user.setHead("20.gif");
		user.setGender(1);
		return user;
	}
	
	/**
	 * 自动装配
	 */
	public UserBiz getUserBiz() {
		return new UserBiz();
	}
}
