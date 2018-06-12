package com.tan.spring.sample.bean;

public class HelperLoader {

	public static void init(){
		Class<?>[]classList={ClassHelper.class,BeanHelper.class,IocHelper.class,ControllerHelper.class};
		for (Class<?> clz : classList) {
			ClassUtil.loadClass(clz.getName(), true);
		}
	}
}
