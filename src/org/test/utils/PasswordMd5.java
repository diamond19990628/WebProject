package org.test.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Controller;

@Controller
public class PasswordMd5 {
	public static String getPasswordMd5(String str) throws NoSuchAlgorithmException{
		MessageDigest messagedigest = MessageDigest.getInstance("MD5");
		byte[] input = str.getBytes();//���ַ�תΪbyte����
		byte[] out = messagedigest.digest(input);
		String pwd = Base64.encodeBase64String(out);
		return pwd;
	}
	public static void main(String[] args) {
		try {
			String test = PasswordMd5.getPasswordMd5("123456");
			System.out.println(test);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
