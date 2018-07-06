package com.demo.dao;

import java.util.List;
import java.util.Map;

import com.demo.pojo.User;

public interface UserMapper {
	// 插入操作
	public int insert(Map<String, Object> map);

	// 更新操作
	public int update(Map<String, Object> map);

	// 删除操作
	public int delete(Map<String, Object> map);

	// 验证用户密码，并返回单个用户
	public User getUser(User user);

	// 查询单个用户
	public User getUserInfo(User user);

	// 查询多个用户
	public List<User> getUserList();
}
