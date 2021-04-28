package com.wler.witmed.util;

/**
 * <b>字符串操作工具类</b>
 *
 * @author Monster
 * @version 1.0.0
 */
public class StringUtil {
	/**
	 * <b>判断所给字符串不为空字符串</b>
	 *
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		if (str != null && !"".equals(str)) {
			return true;
		}
		return false;
	}
}
