package com.tan.spring.sample.bean;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.tan.spring.sample.annotation.Action;

public class ControllerHelper {
   
	public static Handler getHandler(String requestMethod,String requestPath) {
		Request request=new Request(requestMethod, requestPath);
		return ACTION_MAP.get(request);
	}

	private static final Map<Request,Handler> ACTION_MAP=new HashMap<Request,Handler>();
	
	static{
		
		Set<Class<?>> controllerSet=ClassHelper.getControllerClassSet();
		
		if(controllerSet!=null){
			for (Class<?> controllerClass : controllerSet) {
				Method[] methods=controllerClass.getDeclaredMethods();
				
				if(methods!=null){
					
					for (Method method : methods) {
						
						if(method.isAnnotationPresent(Action.class)){
							Action action=method.getAnnotation(Action.class);
							String mapping=action.value();
							
							if(mapping.matches("\\w+:/\\w*")){
								
								String[] array=mapping.split(":");
								if(array!=null&&array.length==2){
									String requestMethod=array[0];
									String requestPath=array[1];
									Request request=new Request(requestMethod, requestPath);
									Handler handler=new Handler(controllerClass, method);
									ACTION_MAP.put(request, handler);
								}
								
							}
							
						}
						
					}
					
				}
				
				
			}
		}
		
	}
	
	
}
