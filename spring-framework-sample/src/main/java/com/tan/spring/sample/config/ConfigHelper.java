package com.tan.spring.sample.config;

import java.util.Properties;

import org.smart4j.framework.util.PropsUtil;

public final class ConfigHelper {
      static final Properties CONFIG_PRO= PropsUtil.loadProps(ConfigConstance.CONFIG_FILE);
      
      
      public static String getJdbcDriver(){
    	  return PropsUtil.getString(CONFIG_PRO, ConfigConstance.JDBC_DRIVER);
      }
      
      public static String getJdbcUrl(){
    	  return PropsUtil.getString(CONFIG_PRO, ConfigConstance.JDBC_DRIVER);
      }
      
      public static String getJdbcUsername(){
    	  return PropsUtil.getString(CONFIG_PRO, ConfigConstance.JDBC_USERNAME);
      }
      
      public static String getJdbcPassword(){
    	  return PropsUtil.getString(CONFIG_PRO, ConfigConstance.JDBC_USERNAME);
      }
      
      public static String getAppBasePakage(){
    	  return PropsUtil.getString(CONFIG_PRO, ConfigConstance.APP_BASEPAKAGE);
      }
      
      public static String getAppJspPath(){
    	  return PropsUtil.getString(CONFIG_PRO, ConfigConstance.APP_JSPPATH);
      }
      
      public static String getAppAssetPath(){
    	  return PropsUtil.getString(CONFIG_PRO, ConfigConstance.APP_ASSETPATH);
      }
}
