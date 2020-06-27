package com.fse.service;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fse.bean.ProjectManagerBean;
import com.fse.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = AppConfig.class)
public class ProjectServiceTest {
	
	@Autowired
	ProjectService projectService;
	
	@Test
	public void addProjectTest()
	{
		ProjectManagerBean projectManagerBean = new ProjectManagerBean();
		projectManagerBean.setProject("project1");
		projectManagerBean.setProjectEndDate(new Date());
		projectManagerBean.setProjectStartDate(new Date());
		projectManagerBean.setProjectPriority(1);
		projectService.addProject(projectManagerBean);
		List projectList = projectService.listProject();
		assertNotNull("List should not be null",projectList);
	}
	
	@Test
	public void updateProjectTest()
	{
		ProjectManagerBean projectManagerBean = new ProjectManagerBean();
		projectManagerBean.setProject("project1");
		projectManagerBean.setProjectEndDate(new Date());
		projectManagerBean.setProjectStartDate(new Date());
		projectManagerBean.setProjectPriority(1);
		projectService.updateProject(projectManagerBean);
		List projectList = projectService.listProject();
		assertNotNull("List should not be null",projectList);
	}
	
	@Test
	public void suspendProjectTest()
	{
		projectService.suspendProject(1);
		List projectList = projectService.listProject();
		assertNotNull("List should not be null",projectList);
	}
	
	@Test
	public void listProjectTest()
	{
		ProjectManagerBean projectManagerBean = new ProjectManagerBean();
		projectManagerBean.setProject("project1");
		projectManagerBean.setProjectEndDate(new Date());
		projectManagerBean.setProjectStartDate(new Date());
		projectManagerBean.setProjectPriority(1);
		projectService.addProject(projectManagerBean);
		List projectList = projectService.listProject();
		assertNotNull("List should not be null",projectList);
	}

}
