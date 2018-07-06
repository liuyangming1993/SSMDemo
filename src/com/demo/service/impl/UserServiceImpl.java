package com.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.UserMapper;
import com.demo.pojo.User;
import com.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;// UserMapper 是接口

	public void addUser(Map<String, Object> map) {
		userMapper.insert(map);// 调用接口的方法
	}

	public int updateUser(Map<String, Object> map) {
		return userMapper.update(map);
	}

	public User getUser(User user) {
		return userMapper.getUser(user);
	}

	public User getUserInfo(User user) {
		return userMapper.getUserInfo(user);
	}

	public List<User> getUserList() {
		return userMapper.getUserList();
	}
}