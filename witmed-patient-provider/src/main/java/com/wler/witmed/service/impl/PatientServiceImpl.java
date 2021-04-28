package com.wler.witmed.service.impl;

import com.wler.witmed.dao.PatientDao;
import com.wler.witmed.pojo.patient.entity.Patient;
import com.wler.witmed.pojo.patient.vo.PatientRegistryVO;
import com.wler.witmed.service.PatientService;
import com.wler.witmed.util.Constants;
import com.wler.witmed.util.IdGenerator;
import com.wler.witmed.util.RedisUtil;
import com.wler.witmed.util.ValidationUtil;
import com.wler.witmed.util.vo.ValidationCodeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>系统功能-病人业务层接口实现类</b>
 *
 * @author Monster
 * @version 1.0.0
 */
@Service("patientService")
@Transactional
public class PatientServiceImpl implements PatientService {
	@Autowired
	private PatientDao dao;
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private IdGenerator idGenerator;

	/**
	 * <b>根据手机号码查询用户</b>
	 *
	 * @param cellphone
	 * @return
	 */
	@Override
	public Patient getByCellphone(String cellphone) throws Exception {
		// 创建查询对象
		Patient query = new Patient();
		query.setCellphone(cellphone);
		// 进行列表查询
		List<Patient> list = dao.findListByQuery(query);
		if (list != null && !list.isEmpty()) {
			list.get(0);
		}
		return null;
	}

	/**
	 * <b>将手机号码和验证码保存到 Redis 中</b>
	 *
	 * @param validationCodeVO
	 * @throws Exception
	 */
	@Override
	public void saveValidationCodeToRedis(ValidationCodeVO validationCodeVO) throws Exception {
		redisUtil.saveToRedis(validationCodeVO.getCellphone(),
				validationCodeVO.getValidationCode(),
				Constants.TOKEN_EXPIRE_MILLIS);
	}

	/**
	 * <b>注册患者信息</b>
	 *
	 * @param patientRegistryVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean registryPatient(PatientRegistryVO patientRegistryVO) throws Exception {
		// 从手机号码获得一个验证码
		String code = (String) redisUtil.findFormRedis(patientRegistryVO.getCellphone(), String.class);
		// 比较两个验证码是否相同
		if (code != null && code.equals(patientRegistryVO.getVerificationCode())) {
			// 验证码相同，保存
			Patient entity = new Patient();
			// 将 patientRegistryVO 的数据拷贝到 patient 中
			BeanUtils.copyProperties(patientRegistryVO, entity);
			// 设定主键
			entity.setId(idGenerator.createId());
			if (dao.save(entity) > 0) {
				return true;
			}
		}
		return false;
	}
}
