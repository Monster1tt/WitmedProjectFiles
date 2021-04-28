package com.wler.witmed.util;

import java.util.Properties;

/**
 * <b>系统校验工具类</b>
 *
 * @author Monster
 * @version 1.0.0
 */
public class ValidationUtil {
	private static Properties props = new Properties();

	static {
		try {
			// 加载配置文件 enums.properties
			props.load(ValidationUtil.class.getClassLoader().getResourceAsStream("props/regex.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * <b>手机号码正则表达式</b>
	 */
	private static final String REGEX_CELLPHONE = props.getProperty("regex.cellphone");
	/**
	 * <b>登陆密码正则表达式</b>
	 */
	private static final String REGEX_PASSWORD = props.getProperty("regex.password");


	/**
	 * <b>判断所给定的手机号码是否符合手机号码格式</b>
	 *
	 * @param cellphone
	 * @return
	 */
	public static boolean isCellphone(String cellphone) {
		if (StringUtil.isNotEmpty(cellphone) && cellphone.matches(REGEX_CELLPHONE)) {
			return true;
		}
		return false;
	}

	public static boolean checkPassword(String password) {
		if (StringUtil.isNotEmpty(password) && password.matches(REGEX_PASSWORD)) {
			return true;
		}
		return false;
	}
}
