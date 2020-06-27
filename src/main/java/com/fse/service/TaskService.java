package com.fse.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fse.bean.ProjectManagerBean;

@Service
public interface TaskService {
	
	public void addTask(ProjectManagerBean projectManagerBean);
	public void editTask(ProjectManagerBean projectManagerBean);
	public void endTask(int taskId);
	public List listTask();
}
