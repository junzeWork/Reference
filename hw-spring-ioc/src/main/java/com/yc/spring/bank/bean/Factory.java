package com.yc.spring.bank.bean;

public class Factory {
	private static int count;
	
	public Account accountFactory() {
		return new Account();
	}
	
	
	public static Account create1() {
		return count++ < 3 ? new Account() : Account.getInstance();
	}
}
