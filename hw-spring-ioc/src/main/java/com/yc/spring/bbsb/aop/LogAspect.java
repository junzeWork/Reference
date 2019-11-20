package com.yc.spring.bbsb.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 日志切面  面向切面编程
 * 切面也是一个主键
 * @author 沈俊羽
 *
 */
public class LogAspect {
	
	/**
	 * 切点方法定义
	 * select* 拦截Dao包下所有的select方法
	 */
	public void myPc() {}

	// aspectj  表达式 用于对方法拦截的表达式定义	
	// execution  表示拦截的方法						切点 pointcut
	// com.yc.spring.bbs.biz  拦截的包				
	// (..) 表示拦截参数的个数不限					
	// Before   前置增强
	/**
	 *  构造方法注入  setter注入  接口注入   当前为接口注入
	 * @param jp  Joinpoint 连接点对象 
	 */
	public void log(JoinPoint jp) {
		jp.getSignature(); // 方法签名
		jp.getArgs();// 获取所有参数
		System.out.println("前置增强===》方法签名：" + jp.getSignature());
		System.out.println("前置增强===》获取所有参数：" + Arrays.toString(jp.getArgs()));
	}
	
	//myPc()  引用切点方法
	public void after(JoinPoint jp) {
		jp.getSignature(); // 方法签名
		jp.getArgs();// 获取所有参数
		System.out.println("后置增强===》方法签名：" + jp.getSignature());
		System.out.println("后置增强===》获取所有参数：" + Arrays.toString(jp.getArgs()));
	}
	
	/**
	 * 返回增强
	 * @param jp
	 * returning  用于定义 方法的返回值的名字
	 */
	public void afterReturning(JoinPoint jp,Object ret) {
		jp.getSignature(); // 方法签名
		jp.getArgs();// 获取所有参数
		System.out.println("返回增强===》方法签名：" + jp.getSignature());
		System.out.println("返回增强===》获取所有参数：" + Arrays.toString(jp.getArgs()));
	}
	
	/**
	 * 异常增强
	 * @param jp
	 */
	public void afterThrowing(JoinPoint jp,Exception e) {
		jp.getSignature(); // 方法签名
		jp.getArgs();// 获取所有参数
		System.out.println("异常增强===》方法签名：" + jp.getSignature());
		System.out.println("异常增强===》异常对象：" + e);
		System.out.println("异常增强===》获取所有参数：" + Arrays.toString(jp.getArgs()));
	}
	
	/**
	 * 性能监控
	 * 环绕增强
	 * 	特性: 必须由增强方法来执行业务方法
	 */
	public void around(ProceedingJoinPoint pjp) {
		try {
			long start=System.currentTimeMillis();
			pjp.proceed();	// 执行业务方法
			long time=System.currentTimeMillis()-start;
			System.out.println(pjp.getSignature()+":"+time);
		} catch (Throwable e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * pointcut 注解
	 * aop xml 配置   11.3. Schema-based AOP support
	 *  作业：使用xml配置方式完成AOP配置
	 *  
	 * 每日一讲 aspectj 其他配置方式   11.2. @AspectJ support
	 *  
	 */
	
}
