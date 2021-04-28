package com.wler.witmed.util;

import java.util.Random;

/**
 * <b>编码生成工具类</b>
 *
 * @author Monster
 * @version 1.0.0
 */
public class CodeGenerator {
	public static String generatorValidationCode() {
		Random random = new Random();
		StringBuffer buffer = new StringBuffer();
		while (buffer.length() < 6) {
			buffer.append(String.valueOf(random.nextInt(10)));
		}
		return buffer.toString();
	}
}
