package com.sjy.junit;

public class Assert {

	public static void objEquals(Object before, Object after) {
		if (!before.equals(after)) {
			failNotEquals(before, after);
		}
	}
	
	public static void assertNotNullEquals(Object obj) {
		if(obj==null) {
			failed("该对象为空");
		}
	}
	
	public static void assertTrue(Boolean bool) {
		if(bool==false) {
			failed("实际为:"+bool);
		}
	}

	private static void failNotEquals(Object before, Object after) {
		String message = "期待值:" + before + "但是实际值是:" + after;
		failed(message);
	}

	private static void failed(String message) {
		if (message == null) {
			throw new AssertionError();
		}
		throw new AssertionError(message);
	}

	/*
	 * public static void assertEquals(String before, String after) {
	 * objEquals(before, after); }
	 * 
	 * public static void assertEquals(Integer before, Integer after) {
	 * objEquals(before, after); }
	 * 
	 * public static void assertEquals(Double before, Double after) {
	 * objEquals(before, after); }
	 * 
	 * public static void assertEquals(Long before, Long after) { objEquals(before,
	 * after); }
	 * 
	 * public static void assertEquals(Float before, Float after) {
	 * objEquals(before, after); }
	 * 
	 * public static void assertEquals(Character before, Character after) {
	 * objEquals(before, after); }
	 * 
	 * public static void assertEquals(Boolean before, Boolean after) {
	 * objEquals(before, after); }
	 */
}
