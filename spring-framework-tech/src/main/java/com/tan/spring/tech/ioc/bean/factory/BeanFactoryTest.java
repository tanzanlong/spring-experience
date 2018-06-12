package com.tan.spring.tech.ioc.bean.factory;

import org.junit.Test;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.tan.spring.tech.ioc.bean.vo.User;

@SuppressWarnings("deprecation")
public class BeanFactoryTest {

    @Test
    public void testLoad(){
        BeanFactory bf=new XmlBeanFactory(new ClassPathResource("config/spring-context.xml"));
        User user=(User) bf.getBean("user");
        String name=user.getName();
        System.out.println(name);
        
    }
    
    @Test
    public void testXmlReader(){
        BeanDefinitionReader br=new XmlBeanDefinitionReader(new BeanDefinitionRegistry() {
            
            @Override
            public void removeAlias(String alias) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void registerAlias(String name, String alias) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public boolean isAlias(String name) {
                // TODO Auto-generated method stub
                return false;
            }
            
            @Override
            public String[] getAliases(String name) {
                // TODO Auto-generated method stub
                return null;
            }
            
            @Override
            public void removeBeanDefinition(String beanName) throws NoSuchBeanDefinitionException {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition)
                    throws BeanDefinitionStoreException {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public boolean isBeanNameInUse(String beanName) {
                // TODO Auto-generated method stub
                return false;
            }
            
            @Override
            public String[] getBeanDefinitionNames() {
                // TODO Auto-generated method stub
                return null;
            }
            
            @Override
            public int getBeanDefinitionCount() {
                // TODO Auto-generated method stub
                return 0;
            }
            
            @Override
            public BeanDefinition getBeanDefinition(String beanName) throws NoSuchBeanDefinitionException {
                // TODO Auto-generated method stub
                return null;
            }
            
            @Override
            public boolean containsBeanDefinition(String beanName) {
                // TODO Auto-generated method stub
                return false;
            }
        });
    }
}
