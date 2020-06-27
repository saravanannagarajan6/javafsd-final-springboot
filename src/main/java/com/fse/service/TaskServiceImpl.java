package com.fse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fse.bean.ProjectManagerBean;
import com.fse.dao.TaskDAO;

@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private TaskDAO taskDAO;
	
	public void addTask(ProjectManagerBean projectManagerBean){
		try {
			taskDAO.addTask(projectManagerBean);
	      } catch (Exception ex) { 
	      }
	}

	public void editTask(ProjectManagerBean projectManagerBean){
		try {
			taskDAO.editTask(projectManagerBean);
	      } catch (Exception ex) { 
	      }
	}
	
	public void endTask(int taskId){
		try {
			taskDAO.endTask(taskId);
	      } catch (Exception ex) { 
	     }
	}
	
	public List listTask() {
		List taskList = null;
		try {
			taskList =  taskDAO.listTask();
	      } catch (Exception ex) { 
	     }
		return taskList;
	}

}
