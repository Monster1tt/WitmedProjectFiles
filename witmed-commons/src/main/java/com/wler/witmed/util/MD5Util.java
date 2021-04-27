package com.wler.witmed.util;

import java.security.MessageDigest;

/**
 * <b>智慧医疗-MD5加密工具类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class MD5Util {
	private static final String KEY_MD5 = "MD5";
	
	public static String encrypt(String message) {
		StringBuffer sb = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance(KEY_MD5);
			byte[] inputData = message.getBytes("UTF-8");
			byte[] encryptionData = md.digest(inputData);
			for (int i = 0; i < encryptionData.length; i++) {
				int value = ((int) encryptionData[i]) & 0xff;
				if (value < 16) {
					sb.append("0");
				}
				sb.append(Integer.toHexString(value));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString().toUpperCase();
	}

	public static void main(String[] args) {
		System.out.println(MD5Util.encrypt("123456"));
	}
}
