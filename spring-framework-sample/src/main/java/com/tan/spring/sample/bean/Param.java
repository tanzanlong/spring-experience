package com.tan.spring.sample.bean;

import java.util.Map;

import org.smart4j.framework.util.CastUtil;

public class Param {
 public Map<String, Object> getParamMap() {
		return paramMap;
	}

private  Map<String,Object>paramMap;
 
 public Param(Map<String,Object>paramMap){
	 this.paramMap=paramMap;
 }
 
 public Long getLong(String name){
	return  CastUtil.castLong(paramMap.get(name));
 }
 
 
}
