package com.wler.witmed.base.pojo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>智慧医疗基础实体信息</b>
 * @author Monster
 * @version 1.0.0
 */
public class BaseEntity implements Serializable {
	private static final long serialVersionUID = 2144618206685352896L;
	private String status;                     // 系统状态： 0-禁用 1-启用
	private String createUser;                  // 创建人
	private Date createTime;                    // 创建时间
	private String updateUser;                  // 修改人
	private Date updateTime;                    // 修改时间

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
