package com.fse.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fse.bean.ProjectManagerBean;
import com.fse.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = AppConfig.class)
public class UserServiceTest {
	
	@Autowired
	UserService userService;
	
	@Test
	public void addUserTest()
	{
		ProjectManagerBean projectManagerBean1 = null;
		projectManagerBean1 = new ProjectManagerBean();
		projectManagerBean1.setEmployeeId(1);
		projectManagerBean1.setFirstName("Firstname");
		projectManagerBean1.setLastName("Lastname");
		userService.addUser(projectManagerBean1);
		List userList = userService.listUser();
		assertNotNull("List should not be null",userList);
	}
	
	@Test
	public void editUserTest()
	{
		ProjectManagerBean projectManagerBean1 = null;
		projectManagerBean1 = new ProjectManagerBean();
		projectManagerBean1.setUserId(1);
		projectManagerBean1.setEmployeeId(1);
		projectManagerBean1.setFirstName("Firstname");
		projectManagerBean1.setLastName("Lastname");
		userService.editUser(projectManagerBean1);
		List userList = userService.listUser();
		assertNotNull("List should not be null",userList);
	}
	
	@Test
	public void deleteUserTest()
	{
		userService.deleteUser(1);
		List userList = userService.listUser();
		assertNotNull("List should not be null",userList);
	}
	
	@Test
	public void listUserTest()
	{
		ProjectManagerBean projectManagerBean1 = null;
		List userList = userService.listUser();
		assertNotNull("List should not be null",userList);
	}

}
