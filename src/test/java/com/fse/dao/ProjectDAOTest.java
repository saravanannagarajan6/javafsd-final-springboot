package com.fse.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fse.bean.ProjectManagerBean;
import com.fse.config.AppConfig;
import com.fse.hibernate.Project;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = AppConfig.class)
public class ProjectDAOTest {
	
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
		projectDAO.addProject(projectManagerBean);
		List projectList = projectDAO.listProject();
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
		projectDAO.updateProject(projectManagerBean);
		Project project = projectDAO.getProject(1);
		assertEquals(project.getProject(), "project1");
	}
	
	@Test
	public void suspendProjectTest()
	{
		projectDAO.suspendProject(1);
		Project project = projectDAO.getProject(1);
		assertNull(" should  be null",project);
	}
	
	@Test
	public void listProjectTest()
	{
		ProjectManagerBean projectManagerBean = new ProjectManagerBean();
		projectManagerBean.setProject("project1");
		projectManagerBean.setProjectEndDate(new Date());
		projectManagerBean.setProjectStartDate(new Date());
		projectManagerBean.setProjectPriority(1);
		projectDAO.addProject(projectManagerBean);
		List projectList = projectDAO.listProject();
		assertNotNull("List should not be null",projectList);
	}

}
