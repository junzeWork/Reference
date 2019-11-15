package com.sjy.junit;

public class JunitTest {
	
	@Before
	public void before() {
		System.out.println("------before------");
	}
	
	@After
	public void after() {
		System.out.println("------after------");
	}
	
	@Test
	public void run() {// 失败
		System.out.println("------run------");
		Assert.assertNotNullEquals(null);
	}
	
	@Test
	public void eat() {// 失败
		System.out.println("------eat------");
		Assert.assertTrue(false);
	}
	
	@Test
	public void game() {// 成功
		System.out.println("------game------");
		Assert.objEquals(1, 1);
	}
	
	@Test
	public void drink() {// 成功
		System.out.println("------drink------");
	}
	
	@Test
	public void sleep() {// 成功
		System.out.println("------sleep------");
	}
}
