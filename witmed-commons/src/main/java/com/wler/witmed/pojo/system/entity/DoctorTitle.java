package com.wler.witmed.pojo.system.entity;

import com.wler.witmed.base.pojo.entity.BaseEntity;

/**
 * <b>医生职称实体类</b>
 *
 * @author Monster
 * @version 1.0.0
 */
public class DoctorTitle extends BaseEntity {
	private static final long serialVersionUID = 3638184035958661607L;
	private String parentCode;                      // 上级职称编码
}
