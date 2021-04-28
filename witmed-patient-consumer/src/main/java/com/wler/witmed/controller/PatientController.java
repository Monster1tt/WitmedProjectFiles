package com.wler.witmed.controller;

import com.wler.witmed.base.controller.BaseController;
import com.wler.witmed.base.pojo.vo.ResponseVO;
import com.wler.witmed.pojo.patient.entity.Patient;
import com.wler.witmed.pojo.patient.vo.PatientRegistryVO;
import com.wler.witmed.transport.patient.PatientTransport;
import com.wler.witmed.util.CodeGenerator;
import com.wler.witmed.util.MD5Util;
import com.wler.witmed.util.ValidationUtil;
import com.wler.witmed.util.message.CloopenSMSUtil;
import com.wler.witmed.util.vo.ValidationCodeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <b>系统功能-病人控制层类</b>
 *
 * @author Monster
 * @version 1.0.0
 */
@RestController("patientController")
@RequestMapping("/patient/patient")
public class PatientController extends BaseController {
	@Autowired
	private PatientTransport transport;

	/**
	 * <b>查询手机号码是否存在</b>
	 *
	 * @param cellphone
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/cellphone/isExists/{cellphone}")
	public ResponseVO cellphoneIsExists(String cellphone) throws Exception {
		// 判断手机号码是否正确
		if (ValidationUtil.isCellphone(cellphone)) {
			// 根据手机号码查询用户信息
			Patient patient = transport.getByCellphone(cellphone);
			if (patient != null) {
				// 用户存在
				return ResponseVO.getSuccessResponseVO(true);
			}
			return ResponseVO.getSuccessResponseVO(false);
		}
		return ResponseVO.getErrorResponseVO("手机号码格式不正确");
	}

	/**
	 * <b>发送短信验证码</b>
	 *
	 * @param cellphone
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/validationcode/{cellphone}")
	public ResponseVO sendValidationCode(@PathVariable("cellphone") String cellphone) throws Exception {
		// 生成验证码
		String validationCode = CodeGenerator.generatorValidationCode();
		// 手机号码作为 key，将验证码作为 value 存储到 Redis 中
		ValidationCodeVO validationCodeVO = new ValidationCodeVO(cellphone, validationCode);
		transport.saveValidationCodeToRedis(validationCodeVO);
		CloopenSMSUtil.sendVerificationCode(cellphone, validationCode);
		//将获得的验证码返回前端
		return ResponseVO.getSuccessResponseVO("验证码发送成功");
	}

	/**
	 * <b>患者注册</b>
	 *
	 * @param patientRegistryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/registry")
	public ResponseVO registryPatient(@RequestBody PatientRegistryVO patientRegistryVO) throws Exception {
		// 校验手机号码和登录密码是否符合要求
		if (ValidationUtil.isCellphone(patientRegistryVO.getCellphone()) && ValidationUtil.checkPassword(patientRegistryVO.getPassword())) {
			// 校验手机号码唯一
			Patient patient = transport.getByCellphone(patientRegistryVO.getCellphone());
			if (patient == null) {
				// 登录密码加密
				patientRegistryVO.setPassword(MD5Util.encrypt(patientRegistryVO.getPassword()));
				// 进行保存
				if (transport.registryPatient(patientRegistryVO)) {
					return ResponseVO.getSuccessResponseVO("注册成功");
				}
				return ResponseVO.getErrorResponseVO("注册失败");
			}
			return ResponseVO.getErrorResponseVO("该手机号码已被注册");
		}
		return ResponseVO.getErrorResponseVO("注册失败1`");
	}
}
