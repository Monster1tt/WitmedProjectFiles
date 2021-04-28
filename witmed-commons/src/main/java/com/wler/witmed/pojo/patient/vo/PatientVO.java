package com.wler.witmed.pojo.patient.vo;

import com.wler.witmed.base.pojo.vo.BaseVO;

/**
 * <b>病人视图类</b>
 *
 * @author Monster
 * @version 1.0.0
 */
public class PatientVO extends BaseVO {
	private static final long serialVersionUID = 6044165298698554874L;
	private String id;
	private String name;
	private String cellphone;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
}
