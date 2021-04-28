package com.wler.witmed.pojo.patient.vo;

import java.io.Serializable;

/**
 * <b>患者注册视图信息</b>
 *
 * @author Monster
 * @version 1.0.0
 */
public class PatientRegistryVO implements Serializable {
	private static final long serialVersionUID = -1048115629217504529L;
	private String cellphone;
	private String password;
	private String verificationCode;

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
}
