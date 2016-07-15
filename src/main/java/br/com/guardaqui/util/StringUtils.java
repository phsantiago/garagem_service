package br.com.guardaqui.util;

import java.util.regex.Pattern;

public class StringUtils {
	private final static Pattern hasNumber = Pattern.compile("\\d");
	public static boolean isEmail(String email){
		return email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}
	
	public static boolean validPassword(String senha){
		if(senha.length() < 8) return false;
		if(!hasNumber.matcher(senha).find()) return false;
		return true;
	}
}
