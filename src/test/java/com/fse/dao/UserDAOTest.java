package com.fse.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;
	
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fse.bean.ProjectManagerBean;
import com.fse.config.AppConfig;
import com.fse.hibernate.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = AppConfig.class)
public class UserDAOTest {
	
	@Autowired
	UserDAO userDAO;
	
	@Test
	public void addUserTest()
	{
		ProjectManagerBean projectManagerBean1 = null;
		projectManagerBean1 = new ProjectManagerBean();
		projectManagerBean1.setEmployeeId(1);
		projectManagerBean1.setFirstName("Firstname");
		projectManagerBean1.setLastName("Lastname");
		userDAO.addUser(projectManagerBean1);
		List userList = userDAO.listUser();
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
		userDAO.addUser(projectManagerBean1);
		User user = userDAO.getUser(1);
		assertEquals(user.getFirstName(), "Firstname");
	}
	
	@Test
	public void deleteUserTest()
	{
		userDAO.deleteUser(1);
		User user = userDAO.getUser(1);
		assertNull("User should  be null",user);
	}
	
	@Test
	public void listUserTest()
	{
		ProjectManagerBean projectManagerBean1 = null;
		projectManagerBean1 = new ProjectManagerBean();
		projectManagerBean1.setEmployeeId(1);
		projectManagerBean1.setFirstName("Firstname");
		projectManagerBean1.setLastName("Lastname");
		userDAO.addUser(projectManagerBean1);
		List userList = userDAO.listUser();
		assertNotNull("List should not be null",userList);
	}

}
