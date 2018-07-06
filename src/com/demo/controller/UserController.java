package com.demo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.demo.pojo.User;
import com.demo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/validateUser")
	public String login(User user, HttpSession session) {
		user = userService.getUser(user);// 验证用户密码
		if (user == null) {
			return "login";
		} else {
			session.setAttribute("userName", user.getUserName());
			return "welcome";
		}
	}

	@RequestMapping("/regUser")
	public String regUser() {
		return "regUser";
	}

	@RequestMapping("/addUser")
	public String addUser(User user) {// 新增用户
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", user.getUserName());
		map.put("password", user.getPassword());
		map.put("name", user.getName());
		userService.addUser(map);
		return "login";
	}

	@RequestMapping("/getUserInfo")
	String getUserInfo(User user, Model model) {
		user = userService.getUserInfo(user);
		model.addAttribute("user", user);
		return "userInfo";
	}

	@RequestMapping("/updateUser")
	String updateUser(User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", user.getUserId());
		map.put("userName", user.getUserName());
		map.put("password", user.getPassword());
		map.put("name", user.getName());
		userService.updateUser(map);
		return "userInfo";
	}

	@RequestMapping(value = "/userlist")
	public String listUser(Model model) {// 查看用户列表
		List<User> list = userService.getUserList();
		model.addAttribute("userList", list);
		return "userList";
	}

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public void getUser(HttpServletResponse response) throws IOException {
		List<User> list = userService.getUserList();
		String user = JSON.toJSON(list.get(0)).toString();
		response.getOutputStream().write(user.getBytes("UTF-8"));
	}
	
	@RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
	@ResponseBody
	public String getUserInfo(HttpServletResponse response) throws IOException {
		List<User> list = userService.getUserList();
		String user = JSON.toJSON(list.get(0)).toString();
		return user;
	}

}