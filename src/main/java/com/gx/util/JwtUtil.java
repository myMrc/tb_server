package com.gx.util;

import com.gx.entity.TUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
@ConfigurationProperties(prefix = "jwt.token")
public class JwtUtil {

    //时间
    private long expire;
    private String secrst;
    private String header;

    //生成
    public String setToken(Integer userId){
        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime() + 1000 * expire);
        return Jwts.builder()
                .setHeaderParam("typ","JWT")
                .setId(userId.toString())
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512,secrst)
                .compact();
    }
    //解析
    public Claims getToken(String jwt){
        try {
            return Jwts.parser()
                        .setSigningKey(secrst)
                        .parseClaimsJws(jwt)
                        .getBody();
        }catch (Exception e){
            return null;
        }
    }
    //验证
    public boolean isToken(Claims claims){
        boolean before = claims.getExpiration().before(new Date());
        return claims.getExpiration().before(new Date());
    }
}
