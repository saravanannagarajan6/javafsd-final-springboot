package com.fse.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.fse.bean.ProjectManagerBean;
import com.fse.hibernate.Task;

@Repository
public interface TaskDAO {
	
	public void addTask(ProjectManagerBean projectManagerBean);
	public void editTask(ProjectManagerBean projectManagerBean);
	public void endTask(int taskId);
	public List listTask();
	public Task getTask(int taskId);
}
