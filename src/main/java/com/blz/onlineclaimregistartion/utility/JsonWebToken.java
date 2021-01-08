package com.blz.onlineclaimregistartion.utility;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

import org.springframework.stereotype.Service;

import com.blz.onlineclaimregistartion.exceptions.UserException;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

@Service
public class JsonWebToken {

	private static final String secretKey = "SCH567";
	private static final String issuer = "Techurate";
	private static final String subject = "Authentication";
	private static SignatureAlgorithm signatureAlgorithm;
	private static long nowMillis;
	private static Date now;
	private static final long REGISTRATION_EXP = 10800000;

	public static String createToken(long id) {
		long ttlMillis = REGISTRATION_EXP;
		signatureAlgorithm = SignatureAlgorithm.HS256;//Header
		nowMillis = System.currentTimeMillis();
		now = new Date(nowMillis);//payload part
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		JwtBuilder builder = Jwts.builder().setId(String.valueOf(id)).setIssuedAt(now).setSubject(subject)
				.setIssuer(issuer).signWith(signatureAlgorithm, signingKey);//payload 

		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}
		return builder.compact();
	}

	
	public static Long decodeToken(String jwt) {
		try {
			return Long.parseLong(Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secretKey))
					.parseClaimsJws(jwt).getBody().getId());
		}catch(MalformedJwtException  | SignatureException e) {
			throw new UserException("Token is incorrect");
		}
		
	}
}
