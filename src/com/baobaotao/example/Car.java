package com.baobaotao.example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

	private String brand;
	private String color;
	private int maxSpeed;

	private BeanFactory beanFactory;
	private String beanName;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		System.out.println("调用setBrand----设置属性");
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	/*
	 * 构造函数
	 */
	public Car() {
		System.out.println("调用Car构造函数");
	}

	public void introduce() {
		System.out.println("brand:" + brand);
	}

	/*
	 * BeanFactoryAware
	 * 
	 * @see
	 * org.springframework.beans.factory.BeanFactoryAware#setBeanFactory(org.
	 * springframework.beans.factory.BeanFactory)
	 */
	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println("BeanFactoryAware的接口方法 ----- setBeanFactory()");
		this.beanFactory = arg0;
	}

	/*
	 * BeanNameAware
	 */
	@Override
	public void setBeanName(String arg0) {
		System.out.println("BeanNameAware的接口方法 ----- setBeanName()");
		this.beanName = arg0;
	}

	/*
	 * InitializingBean
	 * 
	 * @see
	 * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean的接口方法 ----- afterPropertiesSet()");

	}

	/*
	 * DisposableBean
	 * 
	 * @see org.springframework.beans.factory.DisposableBean#destroy()
	 */
	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean的接口方法 ----- destroy()");
	}

	public void myInit() {
		System.out.println("调用init-method所指定的myInit(), 将maxSpeed设置为240");
		this.maxSpeed = 240;
	}
	
	public void myDestroy() {
		System.out.println("调用destory-method所指定的myDestroy()");
	}
}
