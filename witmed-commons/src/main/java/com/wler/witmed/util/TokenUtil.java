package com.wler.witmed.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <b>智慧医疗-JWT Token 工具类</b>
 * <p>
 *     1、为系统认证用户生成对应的 Token 信息。<br/>
 *     2、根据所给定的 Token 进行验证获得其中相应数据。
 * </p>
 *
 * @author Arthur
 * @version 1.0.0
 */
public class TokenUtil {
	// 设定生成 Token 的加密算法
	private static Algorithm algorithm = Algorithm.HMAC256(Constants.TOKEN_SECRET_KEY);

	/**
	 * <b>使用认证用户主键生成 Token 信息</b>
	 * @param id
	 * @return
	 */
	public static String createToken(String id) {
		// 创建 JWTCreator 对象
		JWTCreator.Builder builder = JWT.create();
		// 对于生成的最终 Token 由三部分组成：头部信息（格式和算法）、有效载荷和签名
		// 1、创建头部信息，对于头部信息，本身可使用一个 Map 来完成
		Map<String, Object> headerMap = new HashMap<String, Object>();
		// 设定该信息为 JWT Token
		headerMap.put("typ", "JWT");
		// 设定所使用的加密算法为 HS256
		headerMap.put("alg", "HS256");
		// 创建头部信息
		builder.withHeader(headerMap);
		// 2、设定有效载荷
		builder.withClaim("id", id);
		// 设定该 Token 的有效时间，计算过期时间
		Long expireTime = System.currentTimeMillis() + Constants.TOKEN_EXPIRE_MILLIS;
		builder.withExpiresAt(new Date(expireTime));
		// 3、设定签名，生成 Token
		String token = builder.sign(algorithm);

		return token;
	}

	/**
	 * <b>校验 Token 信息，获得该 Token 中的有效载荷数据</b>
	 * @param token
	 * @return
	 */
	public static String verifyToken(String token) {
		// 校验此时所给定的 Token 是符合相关形式的
		if (token != null && !"".equals(token.trim())) {
			// 此时 Token 格式有效
			// 获得 Token 校验对象 JWTVerifier
			JWTVerifier verifier = JWT.require(algorithm).build();
			// 对于该 Token 进行校验
			DecodedJWT decodedJWT = verifier.verify(token);
			// 如果能够获得 DecodedJWT 则说明通过秘钥能够将加密 Token 进行解密
			// 提取绑定在 Token 中的有效载荷信息
			String id = decodedJWT.getClaim("id").asString();
			return id;
		}

		return "";
	}
}
