package com.itqiwen.chapter44;

import com.itqiwen.chapter44.domain.User;
import com.itqiwen.chapter44.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter44ApplicationTests {


	@Resource
	private UserMapper userMapper;

	@Test
	public void contextLoads() {

		List<User> allUser = userMapper.findAllUser();
		allUser.forEach(System.out::println);
	}


	@Test
	public void run2(){
		User user = new User();
		user.setName("苏烈");
		user.setSex("男");
		user.setAddress("长城守卫军");
		userMapper.insertUser(user);
	}

	@Test
	public void run3(){
		User userById = userMapper.findUserById(16L);
		System.out.println(userById);
	}

	@Test
	public void run4(){
		User user = userMapper.findUserById(16L);
		if(user != null) {
			userMapper.deleteUserById(16L);
		}
	}
}
