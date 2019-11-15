package com.sjy.reflect;

import java.lang.reflect.*;//Java反射包
import java.util.HashMap;
import java.util.Map;

import com.sjy.junit.Test;

/**
 * 反射
 * @author 沈俊羽
 *
 */
@Test(value = "")
public class Demo {

	private String name;
	private String sn;
	private Integer age;
	
	public String getSn() {
		return sn;
	}
	
	

	@Override
	public String toString() {
		return "Demo [name=" + name + ", sn=" + sn + ", age=" + age + "]";
	}

	public void setSn(String string) {
		this.sn = string;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException {
		Demo d= new Demo();
		d.setName("张三");
		action(d);
		
		Demo d1= new SubDemo();
		d.setName("李四");
		action1(d);
		
		d.setAge(18);
		d.setSn("123456");
		toMap(d,new HashMap<String, Object>());
	}
	
	public static void action(Object obj) throws NoSuchFieldException, SecurityException {
		//通过反射获取属性
		Field f;
//		f=obj.getClass().getDeclaredField("name");	// 根据名字获取类指定的该类定义的属性
//		Field[] fs= obj.getClass().getDeclaredFields();		// 获取该类定义的所有属性
		f=obj.getClass().getField("name");			// 获取类的指定共有属性
		//obj.getClass().getFields();				// 获取类的所有属性
	}
	
	public static void action1(Object obj) throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		//通过反射获取方法
		Method m;
		m = obj.getClass().getMethod("setName", String.class);
		m = obj.getClass().getDeclaredMethod("setName", String.class);
	}
	
	public static void toMap(Object obj,Map<String, Object> map) throws IllegalArgumentException, IllegalAccessException {
		Field [] fs=obj.getClass().getDeclaredFields();
		for (Field f : fs) {
			
			// 获取私有属性的方法一:
			//f.setAccessible(true);//强制访问私有属性  不推荐使用
			// 获取私有属性的方法二
			// 通过属性方法获取|设置属性值
			Object value= f.get(obj);//获取当前属性值
			String name= f.getName();//获取属性名
			map.put(name, value);
		}
		
		System.out.println(map);
	}
	
	
	
}