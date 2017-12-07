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

}
