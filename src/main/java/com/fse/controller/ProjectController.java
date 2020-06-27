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
import com.fse.service.ProjectService;

@Controller
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	 @RequestMapping(
	            value = "/addProject", method = RequestMethod.POST)
		public ResponseEntity<Object> addProject(@RequestBody ProjectManagerBean projectManagerBean) {
		 	ProjectManagerBean projectManagerBean1 = null;
			projectManagerBean1 = new ProjectManagerBean();
			projectManagerBean1.setProject(projectManagerBean.getProject());
			projectManagerBean1.setProjectPriority(projectManagerBean.getProjectPriority());
			projectManagerBean1.setProjectStartDate(projectManagerBean.getProjectStartDate());
			projectManagerBean1.setProjectEndDate(projectManagerBean.getProjectEndDate());
			projectManagerBean1.setUserId(projectManagerBean.getUserId());
			projectService.addProject(projectManagerBean);
			return new ResponseEntity<>("Project is created successfully", HttpStatus.CREATED);
		}
	    
	    @RequestMapping(
	            value = "/editProject", method = RequestMethod.POST)
		public ResponseEntity<Object> editProject(@RequestBody ProjectManagerBean projectManagerBean) {
	    	ProjectManagerBean projectManagerBean1 = null;
				projectManagerBean1 = new ProjectManagerBean();
				projectManagerBean1.setProjectId(projectManagerBean.getProjectId());
				projectManagerBean1.setProject(projectManagerBean.getProject());
				projectManagerBean1.setProjectPriority(projectManagerBean.getProjectPriority());
				projectManagerBean1.setProjectStartDate(projectManagerBean.getProjectStartDate());
				projectManagerBean1.setProjectEndDate(projectManagerBean.getProjectEndDate());
				projectManagerBean1.setTotalNoOfTask(projectManagerBean.getTotalNoOfTask());
				projectManagerBean1.setTaskStatus(projectManagerBean.getTaskStatus());
				projectService.updateProject(projectManagerBean1);
				return new ResponseEntity<>("Project is updated successsfully", HttpStatus.OK);
		}

	    @RequestMapping(
	            value = "/deleteProject/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Object> deleteProject(@PathVariable("id") int projectId) {
			projectService.suspendProject(projectId);
			return new ResponseEntity<>("Project is deleted successsfully", HttpStatus.OK);
		}
	    
	    @RequestMapping(
	            value = "/viewProject", method = RequestMethod.POST)
		public ResponseEntity<Object> viewProject() {
			return new ResponseEntity<>(projectService.listProject(), HttpStatus.OK);
		}
	    
	    @RequestMapping(
	            value = "/test", method = RequestMethod.GET)
		public ResponseEntity<Object> test() {
			return new ResponseEntity<>("Testing", HttpStatus.OK);
		}

}
