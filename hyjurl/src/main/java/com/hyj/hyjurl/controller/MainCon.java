package com.hyj.hyjurl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyj.hyjurl.dto.MainDto;
import com.hyj.hyjurl.form.MainFrm;
import com.hyj.hyjurl.service.MainSer;

@Controller
@RequestMapping(value = "/")
public class MainCon {

	@Autowired
	private MainSer mainService;
	
	@RequestMapping(value = "/getUrlList")
	@ResponseBody
	public List<MainDto> getBoardList(HttpServletRequest request, HttpServletResponse response, MainFrm mainForm) throws Exception {

		List<MainDto> urlList = mainService.getUrlList(mainForm);

		return urlList;
	}
	
	@RequestMapping( value = "/insertUrlList")
	@ResponseBody
	public MainDto insertBoard(HttpServletRequest request, HttpServletResponse response, MainFrm mainForm) throws Exception{
		
		MainDto mainDto = mainService.insertUrlList(mainForm);
		
		return mainDto;
	}

}
