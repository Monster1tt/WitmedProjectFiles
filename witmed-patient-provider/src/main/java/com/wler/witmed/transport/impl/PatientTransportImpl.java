package com.wler.witmed.transport.impl;

import com.wler.witmed.pojo.patient.entity.Patient;
import com.wler.witmed.pojo.patient.vo.PatientRegistryVO;
import com.wler.witmed.service.PatientService;
import com.wler.witmed.transport.patient.PatientTransport;
import com.wler.witmed.util.Constants;
import com.wler.witmed.util.RedisUtil;
import com.wler.witmed.util.vo.ValidationCodeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <b>系统功能-病人传输层接口实现类</b>
 *
 * @author Monster
 * @version 1.0.0
 */
@RestController("patientTransport")
@RequestMapping("/patient/trans/patient")
public class PatientTransportImpl implements PatientTransport {
	@Autowired
	private PatientService service;
	@Autowired
	private RedisUtil redisUtil;

	/**
	 * <b>根据手机号码查询用户</b>
	 *
	 * @param cellphone
	 * @return
	 */
	@PostMapping("/cellphone")
	@Override
	public Patient getByCellphone(@RequestParam String cellphone) throws Exception {
		return service.getByCellphone(cellphone);
	}

	/**
	 * <b>将手机号码和验证码保存到 Redis 中</b>
	 *
	 * @param validationCodeVO
	 * @throws Exception
	 */
	@Override
	@PostMapping("/validationcode/redis")
	public void saveValidationCodeToRedis(@RequestBody ValidationCodeVO validationCodeVO) throws Exception {
		service.saveValidationCodeToRedis(validationCodeVO);

	}

	/**
	 * <b>注册患者信息</b>
	 *
	 * @param patientRegistryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/registry")
	public boolean registryPatient(@RequestBody PatientRegistryVO patientRegistryVO) throws Exception {
		return service.registryPatient(patientRegistryVO);
	}
}
