package br.com.guardaqui.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class CryptoUtils {
	public static String hashSha512(String text) throws NoSuchAlgorithmException {
		MessageDigest mda = MessageDigest.getInstance("SHA-512");
		byte[] bytesSenha = text.getBytes();
		byte[] bytesSenhaHash = mda.digest(bytesSenha);
		String senhaHash = Base64.getEncoder().encodeToString(bytesSenhaHash);
		return senhaHash;
	}
	
	public static String hashSha512(String text, String salt) throws NoSuchAlgorithmException {
		return hashSha512(text+"#"+salt);
	}
}
