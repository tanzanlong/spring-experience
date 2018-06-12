package com.tan.spring.tech.ioc.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextSample {
public static void main(String[] args) {
    ApplicationContext ali=new ClassPathXmlApplicationContext();
    ali.getBean("");
}
}
