package com.tan.spring.sample.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamUtil {

	
	public static String getString(InputStream is){
		StringBuilder stringBuilder=new StringBuilder();
		BufferedReader reader= new BufferedReader(new InputStreamReader(is));
		String line;
		
		try {
			while((line=reader.readLine())!=null){
				stringBuilder.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return stringBuilder.toString();
	}
	
}
