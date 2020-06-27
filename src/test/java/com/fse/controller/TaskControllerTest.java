package com.fse.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fse.bean.ProjectManagerBean;
import com.fse.config.AppConfig;
import com.fse.dao.TaskDAO;
import com.fse.hibernate.Task;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = AppConfig.class)
public class TaskControllerTest {
	
	@Autowired
	TaskController taskController;
	
	@Autowired
	TaskDAO taskDAO;
	
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
		taskController.addTask(projectManagerBean1);
		ResponseEntity<Object> task = taskController.viewTask();
		assertNotNull("Object should not be null",task);
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
		taskController.editTask(projectManagerBean1);
		Task task = taskDAO.getTask(2);
		assertEquals(task.getTask(), "Edit Task");
	}
	
	@Test
	public void deleteTaskTest()
	{
		taskController.deleteTask(1);
		Task task = taskDAO.getTask(1);
		assertNull("task object should  be null",task);
	}
	
	@Test
	public void viewTaskTest()
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
		taskController.addTask(projectManagerBean1);
		ResponseEntity<Object> task = taskController.viewTask();
		assertNotNull("Object should not be null",task);
	}


}
