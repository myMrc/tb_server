package com.gx.util;

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
    public String setToken(String username){
        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime() + 1000 * expire);
        return Jwts.builder()
                .setHeaderParam("typ","JWT")
                .setSubject(username)
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
        System.out.println(before);
        return claims.getExpiration().before(new Date());
    }
}
