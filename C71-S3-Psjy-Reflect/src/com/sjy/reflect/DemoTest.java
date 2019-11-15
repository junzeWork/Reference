package com.sjy.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


public class DemoTest {

	
	@Override  //覆盖注解   表示该方法是覆盖父类的方法
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	public static void main(String[] args) throws Exception {
		Demo d= new Demo();
		d.setName("张三");
		//Demo.action(d);
		
		Demo d1= new SubDemo();
		d.setName("李四");
		Demo.action1(d);
		
		d.setAge(18);
		d.setSn("123456");
		toMap(d,new HashMap<String, Object>());
		
	}
	
	public static <T> void toMap(Object obj,Map<String, Object> map) throws Exception {
		Field [] fs=obj.getClass().getDeclaredFields();
		Method[] me=obj.getClass().getDeclaredMethods();
		for (Field f : fs) {
			// 获取私有属性的方法一:
			//f.setAccessible(true);//强制访问私有属性  不推荐使用
			// 获取私有属性的方法二
			// 通过属性方法获取|设置属性值     通过属性方法获取属性值
			f.getType();
			
			String getMethodName="get"+f.getName().substring(0, 1).toUpperCase()+f.getName().substring(1);
			Method getMethod=obj.getClass().getMethod(getMethodName);
			
			//用于执行方法的方法
			Object value= getMethod.invoke(obj); // obj.getXxx();
			
			
			// Object value= f.get(obj);//获取当前属性值
			String name= f.getName();//获取属性名
			map.put(name, value);
		}
		
		System.out.println(map);
	}
}
