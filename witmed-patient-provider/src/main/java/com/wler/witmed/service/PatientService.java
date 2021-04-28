package com.wler.witmed.service;

import com.wler.witmed.pojo.patient.entity.Patient;
import com.wler.witmed.pojo.patient.vo.PatientRegistryVO;
import com.wler.witmed.util.vo.ValidationCodeVO;

/**
 * <b>系统功能-病人业务层接口</b>
 *
 * @author Monster
 * @version 1.0.0
 */
public interface PatientService {
	/**
	 * <b>根据手机号码查询用户</b>
	 *
	 * @param cellphone
	 * @return
	 */
	Patient getByCellphone(String cellphone) throws Exception;

	/**
	 * <b>将手机号码和验证码保存到 Redis 中</b>
	 *
	 * @param validationCodeVO
	 * @throws Exception
	 */
	void saveValidationCodeToRedis(ValidationCodeVO validationCodeVO) throws Exception;

	/**
	 * <b>注册患者信息</b>
	 *
	 * @param patientRegistryVO
	 * @return
	 * @throws Exception
	 */
	boolean registryPatient(PatientRegistryVO patientRegistryVO) throws Exception;
}
