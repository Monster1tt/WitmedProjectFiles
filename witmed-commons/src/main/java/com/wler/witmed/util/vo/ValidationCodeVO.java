package com.wler.witmed.util.vo;

import java.io.Serializable;

/**
 * <b>手机号码和验证码视图信息</b>
 *
 * @author Monster
 * @version 1.0.0
 */
public class ValidationCodeVO implements Serializable {
	private static final long serialVersionUID = 4236671426650831767L;
	private String cellphone;                           // 手机号
	private String ValidationCode;                      // 验证码

	public ValidationCodeVO() {
	}

	public ValidationCodeVO(String cellphone, String validationCode) {
		this.cellphone = cellphone;
		ValidationCode = validationCode;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getValidationCode() {
		return ValidationCode;
	}

	public void setValidationCode(String validationCode) {
		ValidationCode = validationCode;
	}
}
