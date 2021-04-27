package com.wler.witmed.base.pojo.enums;

/**
 * <b>智慧医疗系统状态枚举信息</b>
 * @author Monster
 * @version 1.0.0
 */
public enum StatusEnum {
	STATUS_ENABLE(EnumConstants.STATUS_ENABLE,"启用"),
	STATUS_DISABLE(EnumConstants.STATUS_DISABLE,"禁用");

	private String code;                    // 编码
	private String remake;                  // 说明

	private StatusEnum(String code, String remake) {
		this.code = code;
		this.remake = remake;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRemake() {
		return remake;
	}

	public void setRemake(String remake) {
		this.remake = remake;
	}
}
