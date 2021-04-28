package com.wler.witmed.pojo.patient.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>病人实体类</b>
 *
 * @author Monster
 * @version 1.0.0
 */

public class Patient implements Serializable {
	private static final long serialVersionUID = -2027523232643423411L;
	private String id;
	private String cellphone;
	private Date createTime;                        // 创建时间
	private Date updateTime;                        // 修改时间

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
}
