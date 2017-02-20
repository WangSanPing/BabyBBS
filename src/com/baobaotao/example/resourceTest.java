package com.baobaotao.example;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class resourceTest {

	@RequestMapping("/ClassPathResource.html")
	public void classPathResourceTest() throws IOException {
		// String filePath = "/Users/oukyoku/Desktop/test.txt";

		// Resource res1 = new ClassPathResource("/WEB-INF/resource/test.txt");
		//
		// InputStream ins1 = res1.getInputStream();
		// System.out.println("res1: " + res1.getFilename());

		// bean的生命周期
		// BeanLifeCycle.LifeCycleInBeanFactory();
	}

	@RequestMapping("/FileSystemResource.html")
	public void fileSystemResourceTest() throws IOException {
		String filePath = "/Users/oukyoku/Desktop/test.txt";

		Resource res1 = new FileSystemResource(filePath);

		// InputStream ins1 = res1.getInputStream();
		System.out.println("res1: " + res1.getFilename());
	}
}
