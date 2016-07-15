package br.com.guardaqui;

import static org.junit.Assert.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.junit.Test;

import br.com.guardaqui.util.CryptoUtils;

public class Hash {

	@Test
	public void test() throws NoSuchAlgorithmException {
		String text = "1";
		
		String textoHash = CryptoUtils.hashSha512(text);
		
		assertEquals("Tf9Oo0DwqCPxXT9PAati6uDl2lecy4Ufjbnf6ExYsrN7iZA6dA4e4XLaeTpuedVg5ff5vQWKEqKAQz7W+kZRCg==", textoHash);
	}

}
