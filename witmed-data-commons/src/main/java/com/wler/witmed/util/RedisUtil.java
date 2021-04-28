package com.wler.witmed.util;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * <b>智慧医疗 Redis 工具类</b>
 *
 * @author Monster
 * @version 1.0.0
 */
@Component("redisUtil")
public class RedisUtil {
	@Autowired
	private StringRedisTemplate redisTemplate;

	/**
	 * <b>将所给定的对象存储到 Redis 中</b>
	 *
	 * @param key
	 * @param obj
	 * @param expireMillis
	 * @throws Exception
	 */
	public void saveToRedis(String key, Object obj, Long expireMillis) throws Exception {
		// 创建 JsonMapper 对象
		JsonMapper jsonMapper = new JsonMapper();
		// 将给定的对象变为 JSON 格式
		// 将其中双引号变为单引号
		String jsonStr = jsonMapper.writeValueAsString(obj).replace("\"", "'");
		// 将对应的数据存储到 Redis 中
		redisTemplate.opsForValue().set(key, jsonStr);
		if (expireMillis != null && expireMillis > 0) {
			// 时间有效用所给定的时间
			redisTemplate.expire(key, expireMillis, TimeUnit.MILLISECONDS);
		} else {
			// 时间无效使用默认事件
			redisTemplate.expire(key, Constants.REDIS_EXPIRE_MILLIS, TimeUnit.MILLISECONDS);
		}
	}

	/**
	 * <b>根据 key 从 Redis 中获得数据并恢复成相关对象</b>
	 *
	 * @param key
	 * @param objType
	 * @return
	 * @throws Exception
	 */
	public Object findFormRedis(String key, Class objType) throws Exception {
		// 通过 key 从 Redis 中 获得对应的 JSON
		String jsonStr = redisTemplate.opsForValue().get(key);
		// 判断是否能够从 Redis 中获取对应的数据
		if (jsonStr != null) {
			// 此时通过 key 从 Redis 中获得数据，将数据恢复成对象
			JsonMapper jsonMapper = new JsonMapper();
			return jsonMapper.readValue(jsonStr, objType);
		}
		return null;
	}
}
