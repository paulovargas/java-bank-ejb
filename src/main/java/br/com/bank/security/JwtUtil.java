package br.com.bank.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {

    private static final String SECRET = "69e4c9b0-9758-83e9-acd0-cdb0c0dbc502";

    public static String gerarToken(String login){
        return Jwts.builder()
                .setSubject(login)
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    public static String validarToken(String token){
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
