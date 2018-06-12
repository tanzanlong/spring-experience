# spring-framework-simple
spring framework demo


question: https://spring.io/questions

jira:https://jira.spring.io/browse/spr/?selectedTab=com.atlassian.jira.jira-projects-plugin:summary-panel

docs:  https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#beans-introduction



spring 是一个ioc容器 ，它的思想是控制反转。


IOC

IoC也被称为依赖注入（DI）。它是一个过程，对象通过构造函数参数，工厂方法的参数或在工厂方法构造或返回后在对象实例上设置的属性来定义它们的依赖关系，即它们使用的其他对象。容器 在创建bean时会注入这些依赖关系。这个过程基本上是相反的，因此名为Inversion of Control（IoC），通过使用类的直接构造或诸如Service Locator模式之类的机制来控制其依赖关系的实例化或位置的bean本身。


beanfactory---》HierarchicalBeanFactory（具有双亲ioc管理）-----》ConfigurableBeanFactory（定义配置功能）

beanfactory---》ListableBeanFactory-----》ApplicationContext---》WebApplicationContext