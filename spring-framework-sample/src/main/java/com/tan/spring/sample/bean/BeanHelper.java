package com.tan.spring.sample.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BeanHelper {
	 public static Map<Class<?>, Object> getBeanMap() {
		return BEAN_MAP;
	}

	static final Map<Class<?>,Object> BEAN_MAP=new HashMap<Class<?>,Object>();
    
	 static{
		 Set<Class<?>> calssSet=ClassHelper.getBeanClassSet();
		 for (Class<?> beanClass : calssSet) {
			Object instance=ReflectionUtil.newInstance(beanClass);
			BEAN_MAP.put(beanClass, instance);
		}
	 }
    
	 @SuppressWarnings("unchecked")
	public static <T>T getBean(Class<?> clz) {
		 if(!BEAN_MAP.containsKey(clz)){
			 throw new RuntimeException();
		 }
			return (T) BEAN_MAP.get(clz);
		}

}
