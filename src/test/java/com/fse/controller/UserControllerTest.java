package com.fse.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fse.bean.ProjectManagerBean;
import com.fse.config.AppConfig;
import com.fse.dao.UserDAO;
import com.fse.hibernate.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = AppConfig.class)
public class UserControllerTest {
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	UserController userController;
	
	@Test
	public void addUserTest()
	{
		ProjectManagerBean projectManagerBean1 = null;
		projectManagerBean1 = new ProjectManagerBean();
		projectManagerBean1.setEmployeeId(1);
		projectManagerBean1.setFirstName("Firstname");
		projectManagerBean1.setLastName("Lastname");
		userController.addUser(projectManagerBean1);
		ResponseEntity<Object> userObject = userController.viewUser();
		assertNotNull("Object should not be null",userObject);
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
		userController.addUser(projectManagerBean1);
		User user = userDAO.getUser(1);
		assertEquals(user.getFirstName(), "Firstname");
	}
	
	@Test
	public void deleteUserTest()
	{
		userController.deleteUser(1);
		User user = userDAO.getUser(1);
		assertNull("User should  be null",user);
	}
	
	@Test
	public void viewUserTest()
	{
		ProjectManagerBean projectManagerBean1 = null;
		projectManagerBean1 = new ProjectManagerBean();
		projectManagerBean1.setEmployeeId(1);
		projectManagerBean1.setFirstName("Firstname");
		projectManagerBean1.setLastName("Lastname");
		userController.addUser(projectManagerBean1);
		ResponseEntity<Object> userObject = userController.viewUser();
		assertNotNull("Object should not be null",userObject);
	}
}
