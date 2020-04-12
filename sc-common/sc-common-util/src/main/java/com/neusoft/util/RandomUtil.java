package com.neusoft.util;


/**
 * 生成一串随机数
 * @author 戴顺
 * @date 2015-08-14
 */


public class RandomUtil {
	
	/*
	 * @param count :需要产生随机数的个数
	 */
	public static String radmonkey(int count){
		StringBuffer sbf=new StringBuffer();
		for (int i = 0; i <count; i++) {
			int num=(int)(Math.random()*10);
			sbf.append(num);
		}
		
		return sbf.toString();
	}
	
	public static void main(String[] args) {
		System.err.println(radmonkey(32));
	}

}
