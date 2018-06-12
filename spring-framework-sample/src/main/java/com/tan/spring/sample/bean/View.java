package com.tan.spring.sample.bean;

import java.util.HashMap;
import java.util.Map;

public class View {
     public String getPath() {
		return path;
	}

	public Map<String, Object> getModel() {
		return model;
	}

	private String path;
     
     private  Map<String,Object> model;
     
     public View(String path){
    	 this.path=path;
    	 model=new HashMap<String, Object>();
     }
     
     public View addModel(String key,Object value){
    	 model.put(key, value);
    	 return this;
     }
     
     
}
