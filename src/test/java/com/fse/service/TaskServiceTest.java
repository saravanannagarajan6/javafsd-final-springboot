package com.fse.service;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fse.bean.ProjectManagerBean;

public class TaskServiceTest {
	
	@Autowired
	TaskService taskService;
	
	@Test
	public void addTaskTest()
	{
		ProjectManagerBean projectManagerBean1 = null;
		projectManagerBean1 = new ProjectManagerBean();
		projectManagerBean1.setTask("test");
		projectManagerBean1.setTaskPriority(1);
		projectManagerBean1.setTaskStartDate(new Date());
		projectManagerBean1.setTaskEndDate(new Date());
		projectManagerBean1.setParentTask("Parent Task");
   		projectManagerBean1.setParentId(1);
		projectManagerBean1.setProjectId(1);
		projectManagerBean1.setUserId(1);
		taskService.addTask(projectManagerBean1);
		List taskList = taskService.listTask();
		assertNotNull("List should not be null",taskList);
	}
	@Test
	public void editTaskTest()
	{
		ProjectManagerBean projectManagerBean1 = null;
		projectManagerBean1 = new ProjectManagerBean();
		projectManagerBean1.setTaskId(2);
		projectManagerBean1.setTask("Edit Task");
		projectManagerBean1.setTaskPriority(1);
		projectManagerBean1.setTaskStartDate(new Date());
		projectManagerBean1.setTaskEndDate(new Date());
		projectManagerBean1.setParentTask("Parent Task");
   		projectManagerBean1.setParentId(1);
		projectManagerBean1.setProjectId(1);
		projectManagerBean1.setUserId(1);
		taskService.editTask(projectManagerBean1);
		List taskList = taskService.listTask();
		assertNotNull("List should not be null",taskList);
	}
	
	@Test
	public void endTaskTest()
	{
		taskService.endTask(1);
		List taskList = taskService.listTask();
		assertNotNull("List should not be null",taskList);
	}
	
	@Test
	public void listTaskTest()
	{
		ProjectManagerBean projectManagerBean1 = null;
		projectManagerBean1 = new ProjectManagerBean();
		projectManagerBean1.setTask("test");
		projectManagerBean1.setTaskPriority(1);
		projectManagerBean1.setTaskStartDate(new Date());
		projectManagerBean1.setTaskEndDate(new Date());
		projectManagerBean1.setParentTask("Parent Task");
   		projectManagerBean1.setParentId(1);
		projectManagerBean1.setProjectId(1);
		projectManagerBean1.setUserId(1);
		taskService.addTask(projectManagerBean1);
		List taskList = taskService.listTask();
		assertNotNull("List should not be null",taskList);
	}

}
