package com.itqiwen.chapter41;

import com.itqiwen.chapter41.domain.User;
import com.itqiwen.chapter41.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter41ApplicationTests {

	@Resource
	private UserService userService;

	@Test
	public void contextLoads() {
	}


	@Test
	public void run2(){
		User user = new User();
		user.setName("JdbcTemplate");
		user.setSex("女");
		user.setAddress("北京上地");
		userService.saveUser(user);
	}

	@Test
	public void run3(){
		List<User> allUser = userService.findAllUser();
		allUser.forEach(System.out::println);
	}

	@Test
	public void run4(){
		userService.deleteByName("JdbcTemplate");
	}
}
