package com.sjy.junit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义注解
 * @author 沈俊羽
 *
 */
@Inherited	//继承性注解  表示该注解可以被子类继承
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)   // 保持性  RUNTIME 运行时有效
public @interface Test {

	public String name() default "张三";
	
	public int type() default 0;
	
	//如果注解有一个value 属性 那么该属性就是该注解的默认属性,默认属性可以不用写属性名(前提：只定义一个属性时)
	public String value() default "";
}
