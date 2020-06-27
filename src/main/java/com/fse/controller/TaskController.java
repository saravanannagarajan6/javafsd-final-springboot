package com.fse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fse.bean.ProjectManagerBean;
import com.fse.service.TaskService;

@Controller
public class TaskController {

	@Autowired
	private TaskService taskService;
	
    @RequestMapping(
            value = "/addTask", method = RequestMethod.POST)
	public ResponseEntity<Object> addTask(@RequestBody ProjectManagerBean projectManagerBean) {
    		ProjectManagerBean projectManagerBean1 = null;
    		projectManagerBean1 = new ProjectManagerBean();
    		projectManagerBean1.setTask(projectManagerBean.getTask());
    		projectManagerBean1.setTaskPriority(projectManagerBean.getTaskPriority());
    		projectManagerBean1.setTaskStartDate(projectManagerBean.getTaskStartDate());
    		projectManagerBean1.setTaskEndDate(projectManagerBean.getTaskEndDate());
    		projectManagerBean1.setParentId(projectManagerBean.getParentId());
    		projectManagerBean1.setProjectId(projectManagerBean.getProjectId());
    		projectManagerBean1.setUserId(projectManagerBean.getUserId());
			taskService.addTask(projectManagerBean1);
			return new ResponseEntity<>("Task is created successsfully", HttpStatus.OK);
	}
    
    @RequestMapping(
            value = "/editTask", method = RequestMethod.PUT)
	public ResponseEntity<Object> editTask(@RequestBody ProjectManagerBean projectManagerBean) {
    		ProjectManagerBean projectManagerBean1 = null;
    		projectManagerBean1 = new ProjectManagerBean();
    		projectManagerBean1.setTask(projectManagerBean.getTask());
    		projectManagerBean1.setTaskStatus(projectManagerBean.getTaskStatus());
    		projectManagerBean1.setTaskPriority(projectManagerBean.getTaskPriority());
    		projectManagerBean1.setTaskStartDate(projectManagerBean.getTaskStartDate());
    		projectManagerBean1.setTaskEndDate(projectManagerBean.getTaskEndDate());
    		projectManagerBean1.setParentId(projectManagerBean.getParentId());
    		projectManagerBean1.setProjectId(projectManagerBean.getProjectId());
    		projectManagerBean1.setUserId(projectManagerBean.getUserId());
			taskService.editTask(projectManagerBean1);
			return new ResponseEntity<>("Task is updated successsfully", HttpStatus.OK);
	}

    @RequestMapping(
            value = "/deleteTask/{taskId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteTask(@PathVariable("id") int taskId) {
		taskService.endTask(taskId);
		return new ResponseEntity<>("Task is deleted successsfully", HttpStatus.OK);
	}
    
    @RequestMapping(
            value = "/viewTask", method = RequestMethod.POST)
	public ResponseEntity<Object> viewTask() {
    	return new ResponseEntity<>(taskService.listTask(), HttpStatus.OK);
	}
}
