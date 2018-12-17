package com.zb.commom;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangbin on 2018/8/8.
 */
public class JwtToken {
    public static String SECRET = "hehaeha";

    public static String createToken(Integer id, String username){
        try {
            Date iatDate = new Date();

            Calendar nowTime = Calendar.getInstance();
            nowTime.add(Calendar.MINUTE, 15);
            Date expiresDate = nowTime.getTime();

            Map<String, Object> map = new HashMap<>();
            map.put("alg", "HS256");
            map.put("typ", "JWT");

            String token = JWT.create()
                    .withHeader(map)
                    .withClaim("id", id)
                    .withClaim("username", username)
                    .withExpiresAt(expiresDate)
                    .withIssuedAt(iatDate)
                    .sign(Algorithm.HMAC256(SECRET));
            return token;
        } catch (Exception e){
            throw new RuntimeException("Token创建失败");
        }
    }

    public static Map<String, Claim> verifyToken(String token) throws Exception{
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();

        DecodedJWT jwt = null;
        try {
            jwt = verifier.verify(token);
        } catch (Exception e) {
            throw new RuntimeException("登录凭证已过期，请重新登录");
        }

        return jwt.getClaims();
    }
}
