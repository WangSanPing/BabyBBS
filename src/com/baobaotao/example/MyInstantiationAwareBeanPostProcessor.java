package com.baobaotao.example;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

	public Object postProcessBeforeInstantiation(Class beanClass, String beanName) throws BeansException {
		if ("car".equals(beanName)) {
			System.out.println("在实例化Bean---前进行调用");
			System.out.println("MyInstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation");
		}
		return null;
	}

	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {

		if ("car".equals(beanName)) {
			System.out.println("在实例化Bean---后进行调用");
			System.out.println("InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation");
		}

		return true;
	}

	public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean,
			String beanName) throws BeansException {
		if ("car".equals(beanName)) {
			System.out.println("在设置某个属性时调用");
			System.out.println("InstantiationAwareBeanPostProcessor.postProcessPropertyValues");
		}
		return pvs;
	}
}
