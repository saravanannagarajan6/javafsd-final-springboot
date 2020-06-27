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
import com.fse.dao.ProjectDAO;
import com.fse.hibernate.Project;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = AppConfig.class)
public class ProjectControllerTest {
	
	@Autowired
	ProjectController projectController;
	
	@Autowired
	ProjectDAO projectDAO;
	
	@Test
	public void addProjectTest()
	{
		ProjectManagerBean projectManagerBean = new ProjectManagerBean();
		projectManagerBean.setProject("project1");
		projectManagerBean.setProjectEndDate(new Date());
		projectManagerBean.setProjectStartDate(new Date());
		projectManagerBean.setProjectPriority(1);
		projectController.addProject(projectManagerBean);
		ResponseEntity<Object> project = projectController.viewProject();
		assertNotNull("Object should not be null",project);
	}
	
	@Test
	public void updateProjectTest()
	{
		ProjectManagerBean projectManagerBean = new ProjectManagerBean();
		projectManagerBean.setProject("project1");
		projectManagerBean.setProjectEndDate(new Date());
		projectManagerBean.setProjectStartDate(new Date());
		projectManagerBean.setProjectPriority(1);
		projectController.editProject(projectManagerBean);
		Project project = projectDAO.getProject(1);
		assertEquals(project.getProject(), "project1");
	}
	
	@Test
	public void deleteProjectTest()
	{
		projectController.deleteProject(1);
		Project project = projectDAO.getProject(1);
		assertNull(" should  be null",project);
	}
	
	@Test
	public void viewProjectTest()
	{
		ProjectManagerBean projectManagerBean = new ProjectManagerBean();
		projectManagerBean.setProject("project1");
		projectManagerBean.setProjectEndDate(new Date());
		projectManagerBean.setProjectStartDate(new Date());
		projectManagerBean.setProjectPriority(1);
		projectController.addProject(projectManagerBean);
		ResponseEntity<Object> project = projectController.viewProject();
		assertNotNull("Object should not be null",project);
	}

}
