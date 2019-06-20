package jjwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.util.Base64;
import java.util.Date;

/**
 * @ClassName: Main
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/6/20 23:28
 */
public class Main {

    public static void main(String[] args) throws InvalidKeyException {
        //创建JWT之前首先要创建一个base64URL需要的key
        String JWT_SECRET = "caiwei";
        byte[] encodeSecretKey = Base64.getUrlDecoder().decode(JWT_SECRET);
        SecretKey key = new SecretKeySpec(encodeSecretKey, 0,encodeSecretKey.length,"AES");



        //然后根据这个secret创建jwt
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        Date now = new Date();
        JwtBuilder builder = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .setIssuedAt(now)
                .claim("name", "caiwei")
                .claim("role", "student")
                .setIssuer("caiwei")
                .signWith(signatureAlgorithm, key);
        String jwt = builder.compact();
        System.out.println("jwt:" + jwt);


        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(jwt)
                .getBody();
        String name = (String) claims.get("name");
        String role = (String) claims.get("role");
        System.out.println("name:" + name + ";role:" + role);
    }
}
