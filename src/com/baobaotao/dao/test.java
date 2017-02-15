package com.baobaotao.dao;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class test {

	@RequestMapping(value = "/test")
	public String editBook(Model model, @PathVariable long id) {

		return "BookEditForm";
	}
}
