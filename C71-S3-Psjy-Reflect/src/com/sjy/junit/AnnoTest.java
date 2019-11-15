package com.sjy.junit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.sjy.reflect.Demo;
import com.sjy.reflect.SubDemo;

@Test("")
public class AnnoTest {

	@Test("")
	public void play() {
		System.out.println("=========play============");
	}
	
	@Test("")
	public void eat() {
		System.out.println("=========eat============");
	}
	
	@After
	public void after() {
		System.out.println("=========after============");
	}
	
	@Before
	public void before() {
		System.out.println("=========before============");
	}
	
	public void run() {
		System.out.println("===========run=============");
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//返回当前类上的注解
		System.out.println(Demo.class.getAnnotation(Test.class));
		
		System.out.println(SubDemo.class.getAnnotation(Test.class));
		
		AnnoTest annoTest=AnnoTest.class.newInstance(); // == new AnnoTest();
		
		Method [] methods= AnnoTest.class.getMethods();
		List<Method> beforeMethods=new ArrayList<Method>();
		List<Method> testMethods=new ArrayList<Method>();
		List<Method> afterMethods=new ArrayList<Method>();
		for (Method method : methods) {
			if(null!=method.getAnnotation(Before.class)) {
				beforeMethods.add(method);
			}
			if(null!=method.getAnnotation(Test.class)) {
				testMethods.add(method);
			}
			if(null!=method.getAnnotation(After.class)) {
				afterMethods.add(method);
			}
		}
		
		for (Method method : testMethods) {
			for (Method method1 : beforeMethods) {
				method1.invoke(annoTest);
			}
			method.invoke(annoTest);
			for (Method method2 : afterMethods) {
				method2.invoke(annoTest);
			}
		}
	}
}
