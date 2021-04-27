package com.wler.witmed.base.pojo.enums;

import java.util.Properties;

/**
 * <b>智慧医疗枚举信息常量类</b>
 *
 * @author Monster
 * @version 1.0.0
 */
class EnumConstants {
	private static Properties props = new Properties();

	static {
		try {
			// 加载配置文件 enums.properties
			props.load(EnumConstants.class.getClassLoader().getResourceAsStream("props/enums.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * <b>系统状态：启用状态</b>
	 */
	static final String STATUS_ENABLE = props.getProperty("enum.status.enable");

	/**
	 * <b>系统状态：禁用状态</b>
	 */
	static final String STATUS_DISABLE = props.getProperty("enum.status.disable");

	/**
	 *<b>系统响应状态码：系统响应成功</b>
	 */
	static final Integer RESPONSE_SUCCESS = Integer.parseInt(props.getProperty("enum.response.success"));

	/**
	 *<b>系统响应状态码：系统处理业务错误</b>
	 */
	static final Integer RESPONSE_ERROR = Integer.parseInt(props.getProperty("enum.response.error"));
	/**
	 *<b>系统响应状态码：用户未认证</b>
	 */
	static final Integer RESPONSE_UNAUTHC = Integer.parseInt(props.getProperty("enum.response.unauthc"));
	/**
	 *<b>系统响应状态码：系统处理异常</b>
	 */
	static final Integer RESPONSE_EXCEPTION = Integer.parseInt(props.getProperty("enum.response.exception"));
}
