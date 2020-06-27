package com.fse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fse.bean.ProjectManagerBean;
import com.fse.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public void addUser(ProjectManagerBean projectManagerBean) {
		try {
			userDAO.addUser(projectManagerBean);
	      } catch (Exception ex) { 
	        
	      }
	}

	public void editUser(ProjectManagerBean projectManagerBean) {
		try {
			 userDAO.editUser(projectManagerBean);
	      } catch (Exception ex) { 
	    }
	}

	public void deleteUser(int userId) {
		try {
			userDAO.deleteUser(userId);
	      } catch (Exception ex) { 
	     }
	}
	
	public List listUser() {
		List userList = null;
		try {
			userList =  userDAO.listUser();
	      } catch (Exception ex) { 
	     }
		return userList;
	}

}
