package com.itqiwen.chapter43;

import com.itqiwen.chapter43.domain.User;
import com.itqiwen.chapter43.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter43ApplicationTests {

	@Resource
	private UserMapper userMapper;

	@Test
	public void contextLoads() {
	}

	@Test
	public void run(){
		List<User> allUser = userMapper.findAllUser();
		allUser.forEach(System.out::println);
	}

	@Test
	public void run2(){
		userMapper.insertUser("贾宝玉", "男", "大观园");
	}

	@Test
	public void run3(){
		userMapper.deleteUser(20L);
	}

}
