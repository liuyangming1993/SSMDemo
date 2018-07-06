package com.demo.dao;

import java.util.List;
import java.util.Map;

import com.demo.pojo.User;

public interface UserMapper {
	// �������
	public int insert(Map<String, Object> map);

	// ���²���
	public int update(Map<String, Object> map);

	// ɾ������
	public int delete(Map<String, Object> map);

	// ��֤�û����룬�����ص����û�
	public User getUser(User user);

	// ��ѯ�����û�
	public User getUserInfo(User user);

	// ��ѯ����û�
	public List<User> getUserList();
}
