package com.project.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.spring.dto.SpringBoot;
import com.project.spring.service.SpringBootService;

@Controller
public class TestController {
	@Autowired
	SpringBootService springBootService;
	
	@RequestMapping("/sql")
	public @ResponseBody List<SpringBoot> sql() throws Exception{
		System.out.println("dddd");
		System.out.println(springBootService.getAll());
		return springBootService.getAll();
	}
	
	@RequestMapping("/mav")
	public ModelAndView mav() throws Exception{
		//jsp 페이지 테스트
		//모델에 데이터 저장 후 view로 전달
		ModelAndView mav = new ModelAndView("view_test");
		mav.addObject("key","first");
		 
		List<String> fruitList = new ArrayList<String>();
	        
        fruitList.add("apple");
        fruitList.add("orange");
        fruitList.add("banana");
        
        mav.addObject("value", fruitList);
        
		return mav;
	}
}
