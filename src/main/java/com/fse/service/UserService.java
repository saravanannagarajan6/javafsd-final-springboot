package com.fse.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fse.bean.ProjectManagerBean;

@Service
public interface UserService {
	
	public void addUser(ProjectManagerBean projectManagerBean);
	public void editUser(ProjectManagerBean projectManagerBean);
	public void deleteUser(int userId);
	public List listUser();
}
