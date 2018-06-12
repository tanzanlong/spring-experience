package com.tan.spring.sample.bean;

import java.lang.reflect.Field;
import java.util.Map;

import com.tan.spring.sample.annotation.Inject;

public class IocHelper {
	static {
		Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
		if(beanMap!=null){
			for (Map.Entry<Class<?>, Object>beanEntry:beanMap.entrySet()) {
				Class<?> beanClass=beanEntry.getKey();
				Object beanInstance=beanEntry.getValue();
				
				Field[]fields=beanClass.getDeclaredFields();
				if(fields!=null){
					for (Field field : fields) {
						
						if(field.isAnnotationPresent(Inject.class)){
							Class<?> beanFieldClass=field.getType();
							Object beanFieldInstance=beanMap.get(beanFieldClass);
							
							if(beanFieldInstance!=null){
								ReflectionUtil.setField(beanInstance, field, beanFieldInstance);
							}
							
						}
						
						
					}
				}
				
				
				
			}
		}
		
	}
}
