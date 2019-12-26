package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.repository.UsersRepository;
import com.example.service.JoinService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class UsersController {
	
	@Autowired
	private JoinService joinService;

	@Autowired
	private LoginService loginService;

	@PostMapping("/joinRequest")
	public String joinRequest(@RequestParam Map<String, String> paramMap) {
		return joinService.joinUser(paramMap.get("user_id"), paramMap.get("user_pw"), paramMap.get("user_name"));
	}
	
	@PostMapping("/loginRequest")
	public String loginRequest(@RequestParam Map<String, String> paramMap) {
		return loginService.login(paramMap.get("user_id"), paramMap.get("user_pw"));
	}
	
}