package br.com.guardaqui.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
	private final static Pattern hasNumber = Pattern.compile("\\d");
	private final static Pattern hasChar = Pattern.compile("\\w");
	public static boolean isEmail(String email){
		return email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}
	
	public static boolean validPassword(String senha){
		if(senha.length() < 8) return false;
		if(!hasNumber.matcher(senha).find()) return false;
		if(!hasChar.matcher(senha).find()) return false;
		return true;
	}
	
	public static boolean validName(String nome){
		Matcher m = Pattern.compile("^[\\p{L} .'-]+$", Pattern.CASE_INSENSITIVE).matcher(nome);
		if(nome.length() < 3) return false;
		if(!m.find()) return false;
		
		return true;
	}
}
