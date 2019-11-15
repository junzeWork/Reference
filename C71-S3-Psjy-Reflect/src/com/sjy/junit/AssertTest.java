package com.sjy.junit;

public class AssertTest {

	public static void main(String[] args) {
//		Assert.assertEquals(2.1, 2.0);
		
//		Double d1=new Double(2.0);
//		Double d2=new Double(2.1);
		
//		Float d1=new Float(2.0);
//		Float d2=new Float(2.0);
		
//		Character d1=new Character('a');
//		Character d2=new Character('b');
		
//		Boolean d1=true;
//		Boolean d2=true;
		
		String d1=new String("123");
		String d2=new String("1234");
		Assert.objEquals(d1, d2);
	}
}
