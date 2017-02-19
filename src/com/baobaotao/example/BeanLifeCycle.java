package com.baobaotao.example;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/*
 * bean的生命周期
 */
public class BeanLifeCycle {

	static void LifeCycleInBeanFactory() {

		// 装在配置文件并启动容器
		Resource res = new ClassPathResource("/example-beans.xml");
		BeanFactory bf = new XmlBeanFactory(res);

		// 向容器中注册 MyBeanPostProcessor 后处理器
		((ConfigurableBeanFactory) bf).addBeanPostProcessor(new MyBeanPostProcessor());

		// 向容器中注册 MyInstantiationAwareBeanPostProcessor 后处理器
		((ConfigurableBeanFactory) bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

		Car car1 = (Car) bf.getBean("car");
		car1.introduce();
		car1.setColor("红色");

		Car car2 = (Car) bf.getBean("car");

		System.out.println("car1 == car2 :" + (car1 == car2));
		
		((XmlBeanFactory)bf).destroySingletons();
	}
}
