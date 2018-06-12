package com.tan.spring.sample.bean;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ClassUtil {
 
	static final Logger log=LoggerFactory.getLogger(ClassUtil.class);
	
	public static ClassLoader getClassLoader(){
		return Thread.currentThread().getContextClassLoader();
	}
	
	public static Class<?> loadClass(String className,boolean isInitialized){
	Class<?> clz;
		
		try {
			clz=Class.forName(className,isInitialized,getClassLoader());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return clz;
	}
	
	public static Set<Class<?>> getClassSet(String pakageName){
		Set<Class<?>> classSet=new HashSet<Class<?>>();
		
		try {
			Enumeration<URL> urls=getClassLoader().getResources(pakageName.replace(".", "/"));
			while (urls.hasMoreElements()) {
				URL url = (URL) urls.nextElement();
				if(url!=null){
					String protocal=url.getProtocol();
					
					if("file".equals(protocal)){
						String pakagePath=url.getPath().replaceAll("%20", "");
						addClass(classSet, pakageName, pakagePath);
					}else if("jar".equals(protocal)){
						JarURLConnection jarURLConnection=(JarURLConnection) url.openConnection();
						if(jarURLConnection!=null){
							JarFile jarFile=jarURLConnection.getJarFile();
							if(jarFile!=null){
								Enumeration<JarEntry>jaEntries=jarFile.entries();
								
								while (jaEntries.hasMoreElements()) {
									JarEntry jarEntry = (JarEntry) jaEntries
											.nextElement();

									String jarEntryName=jarEntry.getName();
									
									if(jarEntryName.endsWith(".class")){
										String className=jarEntryName.substring(0, jarEntryName.lastIndexOf(".")).replaceAll("/", ".");
										doAddClass(classSet, className);
									}
									
									
								}
								
							}
						}
					}
					
				}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		return classSet;
	}
	
	
	public static void addClass(Set<Class<?>> classSet,String pakageName,String pakagePath){
		File[] files=new File(pakagePath).listFiles(new FileFilter() {
			@Override
			public boolean accept(File file) {
				return (file.isFile()&&file.getName().endsWith(".class"))||file.isDirectory();
			}
		});
		
		for (File file : files) {
			String filename=file.getName();
			
			if(file.isFile()){
				String classname=filename.substring(0, filename.lastIndexOf("."));
				if(StringUtils.isNotBlank(pakageName)){
					classname=pakageName+"."+classname;
				}
				doAddClass(classSet, classname);
			}else{
				
				String subFilePath=filename;
				if(StringUtils.isNotBlank(pakagePath)){
					subFilePath=pakagePath+"/"+subFilePath;
				}
				
				String subPackageName=filename;
				
				if(StringUtils.isNotBlank(pakageName)){
					subPackageName=pakageName+"."+subPackageName;
				}
				addClass(classSet, pakageName, pakagePath);
			}
			
		}
		
	}
	
	
	public static Set<Class<?>> doAddClass(Set<Class<?>> classSet,String className){
		Class<?> clz=loadClass(className, false);
		classSet.add(clz);
		return classSet;
	}
	
}
