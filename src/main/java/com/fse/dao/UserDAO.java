package com.fse.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fse.bean.ProjectManagerBean;
import com.fse.hibernate.User;

@Repository
public interface UserDAO {
	public void addUser(ProjectManagerBean projectManagerBean);
	public User editUser(ProjectManagerBean projectManagerBean);
	public void deleteUser(int userId);
	public List listUser();
	public User getUser(int userId);
}
