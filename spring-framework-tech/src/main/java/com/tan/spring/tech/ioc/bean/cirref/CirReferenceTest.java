package com.tan.spring.tech.ioc.bean.cirref;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.tan.spring.tech.ioc.bean.vo.User;

@SuppressWarnings("deprecation")
public class CirReferenceTest {

    @Test
    public void testLoad(){
        BeanFactory bf=new XmlBeanFactory(new ClassPathResource("config/spring-context.xml"));
        OrderService orderService=(OrderService) bf.getBean("orderService");
        
    }
    
    
}
