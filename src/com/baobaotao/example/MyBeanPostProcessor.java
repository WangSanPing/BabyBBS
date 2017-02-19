package com.baobaotao.example;

import org.springframework.beans.BeansException;

public class MyBeanPostProcessor implements org.springframework.beans.factory.config.BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.equals("car")) {
			Car car = (Car) bean;
			if (car.getColor() == null) {
				System.out.println("调用BeanPostProcessor.postProcessBeforeInitialization()---设置color为空，设置为默认黑色");
				car.setColor("黑色");
			}
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.equals("car")) {
			Car car = (Car) bean;
			if (car.getMaxSpeed() >= 200) {
				System.out.println("调用BeanPostProcessor.postProcessAfterInitialization()---将maxSpeed调整为200.");
				car.setMaxSpeed(200);
			}
		}
		return bean;
	}

}
