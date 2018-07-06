package com.demo.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.demo.pojo.User;
import com.demo.service.UserService;

public class TestMybatis extends Junit4Test{  
	  
    @Autowired  
    private UserService userService;      
  
    @Test  
    @Transactional  
    @Rollback(false)//��ֹ�����Զ��ع�  
    public void test() {  
        testUser();  
    }  
      
    private void testUser() {  
        //add  
        Map<String,Object> map = new HashMap<String,Object>();  
        map.put("username", "i");  
        map.put("password", "iii");  
        map.put("name", "Test");  
        userService.addUser(map);     
          
        User user = new User();  
        user.setUserName("i");//userName, password ��Ϊ��ѯ����  
        user.setPassword("iii");  
        user = userService.getUser(user);  
        System.out.println(user.getName());       
    }  
}  