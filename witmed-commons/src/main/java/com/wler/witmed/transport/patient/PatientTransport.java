package com.wler.witmed.transport.patient;

import com.wler.witmed.pojo.patient.entity.Patient;
import com.wler.witmed.pojo.patient.vo.PatientRegistryVO;
import com.wler.witmed.util.vo.ValidationCodeVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * <b>系统功能-病人传输层接口</b>
 *
 * @author Monster
 * @version 1.0.0
 */
@FeignClient(name = "witmed-patient-provider")
@RequestMapping("/patient/trans/patient")
public interface PatientTransport {
	/**
	 * <b>根据手机号码查询用户</b>
	 *
	 * @param cellphone
	 * @return
	 */
	@PostMapping("/cellphone")
	Patient getByCellphone(@RequestParam String cellphone) throws Exception;

	/**
	 * <b>将手机号码和验证码保存到 Redis 中</b>
	 *
	 * @param validationCodeVO
	 * @throws Exception
	 */
	@PostMapping("/validationcode/redis")
	void saveValidationCodeToRedis(@RequestBody ValidationCodeVO validationCodeVO) throws Exception;

	/**
	 * <b>注册患者信息</b>
	 *
	 * @param patientRegistryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/registry")
	boolean registryPatient(@RequestBody PatientRegistryVO patientRegistryVO) throws Exception;
}
