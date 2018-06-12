package com.tan.spring.sample.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class CodecUtil {

	
	public static String encode(String source){
		String targe;
		
		try {
			targe=URLEncoder.encode(source, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return targe;
	}
	
	
	public static String decode(String source){
		String targe;
		
		try {
			targe=URLDecoder.decode(source, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return targe;
	}
}
