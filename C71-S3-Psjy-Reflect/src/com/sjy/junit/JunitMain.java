package com.sjy.junit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Junit实现
 * @author 沈俊羽
 *
 */
public class JunitMain {
	
	private static int successCount;
	private static int failCount;

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		JunitTest annoTest =JunitTest.class.newInstance();

		Method[] methods = annoTest.getClass().getMethods();
		List<Method> beforeMethods = new ArrayList<Method>();
		List<Method> testMethods = new ArrayList<Method>();
		List<Method> afterMethods = new ArrayList<Method>();
		for (Method method : methods) {
			if (null != method.getAnnotation(Before.class) && method.getParameterCount()<=0 && Modifier.toString(method.getModifiers()).equals("public")) {
				beforeMethods.add(method);
			}
			if (null != method.getAnnotation(Test.class) && method.getParameterCount()<=0 && Modifier.toString(method.getModifiers()).equals("public")) {
				testMethods.add(method);
			}
			if (null != method.getAnnotation(After.class) && method.getParameterCount()<=0 && Modifier.toString(method.getModifiers()).equals("public")) {
				afterMethods.add(method);
			}
		}

		for (Method method : testMethods) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					for (Method method1 : beforeMethods) {
						try {
							method1.invoke(annoTest);
						} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
							e.printStackTrace();
						}
					}
					try {
						method.invoke(annoTest);
						successCount++;
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						failCount++;
						e.printStackTrace();
					}
					for (Method method2 : afterMethods) {
						try {
							method2.invoke(annoTest);
						} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
			
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("成功数量:"+successCount+"\t"+"失败数量:"+failCount);
	}
}
