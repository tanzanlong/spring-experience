package com.tan.spring.sample.bean;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReflectionUtil {
	static final Logger log=LoggerFactory.getLogger(ReflectionUtil.class);
	
	public static Object newInstance(Class<?> clz){
		Object instance;
		try {
			 instance=clz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return instance;
	}
	
	public static Object invokeMethod(Object obj,Method method,Object ...arges){
		Object result;
		try {
			method.setAccessible(true);
			result=method.invoke(obj, arges);
		} catch ( IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return result;
	}
	
	
	public static void setField(Object obj,Field field,Object value){
		try {
			field.setAccessible(true);
			field.set(obj, value);
		} catch ( IllegalAccessException | IllegalArgumentException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
