package com.tutiendaonline.user.service;


import com.tutiendaonline.user.config.AppConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


@Service
public class JwtService {

    private static String SECRET_KEY = "06b4b1f3f8585a6dc5c653a4e63d75a80670f7a62580f7b13e9ac372d26fc9bbc42796dc59cd6c1a55452858e010a684321fd6d67f0f27b347de2e176d47649b55f0ee4fd61d497018b4ad0bdd3e4d77c2377208fd06801de77db67e6fad1e11621b5060e3e55834abd6b329203fdcd2b0c984d494de6afddc11ef9be714a8f941bc4ca3515d2257e2ea49333e1a491a01a1d5fc3a037d2070a4087ed96c87dfae62aed88da415c7d0f7c727627adfbea4ffc4b34d03132f7030963fb0201628ff78fc24472793acbcb32fbb9f1b2504509ad79e112b88884b396d9920f0eb090928cd1539949962a2fb0f3b96011a86cd9d73d4bb597e522b96c67f289b8ddd5c0d28216eba12cbc5f77714b85bfb95e4fea4d25bd4af47d76355ef2db3e5488ef7ec25533909d9551eb7033dbe7fc23a71bafe840752643703f59b8084a04e2acbe02dce65c58225883d34f9984ef781b3238a31dc7cf5bfa1980ed1e56d555e092ffa843054edd0d6f26129e06e02e3a7cd8681e231726bbadb850cd6a18cd5e9231f2dad8a499215062b00e60148977a286712eeee2e542c72ee218ea1e040fc390c79c5743a2d546f0ee2786da1fe6dcbb5a235018985b45a5cb0e1fcccf1b687f047cea78bd2818f54f700d558d472e74455e32a082d64338ad76b0e32eb5863974f32d794dda80d74d2145f29044972864edbf504b097ed0bab7caf3c";

    public String extractUsername(String token)
    {
        return extraimClaim(token, Claims::getSubject);
    }

    public <T> T extraimClaim(String token, Function<Claims, T> claimsResolver)
    {
        Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }


    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);
    }


    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails
    )
    {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSingKey(), SignatureAlgorithm.ES512)
                .compact();
    }


    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extraimClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token){
        return Jwts
                .parser().setSigningKey(getSingKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSingKey()
    {
        byte[]keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
