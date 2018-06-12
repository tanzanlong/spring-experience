package com.tan.spring.sample.bean;

import java.util.HashSet;
import java.util.Set;

import com.tan.spring.sample.annotation.Controller;
import com.tan.spring.sample.annotation.Service;
import com.tan.spring.sample.config.ConfigHelper;

public class ClassHelper {
	public static Set<Class<?>> getClassSet() {
		return CLASS_SET;
	}
	static final Set<Class<?>> CLASS_SET;
	static{
		String basePackpage=ConfigHelper.getAppBasePakage();
		CLASS_SET=ClassUtil.getClassSet(basePackpage);
	}
	
	public static Set<Class<?>> getServiceClassSet() {
		Set<Class<?>> classSets=new HashSet<Class<?>>();
		for (Class<?> clz : CLASS_SET) {
			if(clz.isAnnotationPresent(Service.class)){
				classSets.add(clz);
			}
		}
		return classSets;
	}
	
	public static Set<Class<?>> getControllerClassSet() {
		Set<Class<?>> classSets=new HashSet<Class<?>>();
		for (Class<?> clz : CLASS_SET) {
			if(clz.isAnnotationPresent(Controller.class)){
				classSets.add(clz);
			}
		}
		return classSets;
	}
	
	public static Set<Class<?>> getBeanClassSet() {
		Set<Class<?>> beanClassSets=new HashSet<Class<?>>();
		beanClassSets.addAll(getControllerClassSet());
		beanClassSets.addAll(getServiceClassSet());
		return beanClassSets;
	}
}
