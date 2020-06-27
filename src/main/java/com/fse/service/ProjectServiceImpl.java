package com.fse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fse.bean.ProjectManagerBean;
import com.fse.dao.ProjectDAO;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	private ProjectDAO projectDAO;
	
	public void addProject(ProjectManagerBean projectManagerBean){
		try {
			projectDAO.addProject(projectManagerBean);
	      } catch (Exception ex) { 
	      }
	}

	public void updateProject(ProjectManagerBean projectManagerBean){
		try {
			 projectDAO.updateProject(projectManagerBean);
	      } catch (Exception ex) { 
	      }
	}
	
	public void suspendProject(int projectId){
		try {
			 projectDAO.suspendProject(projectId);
	      } catch (Exception ex) { 
	      }
	}
	
	public List listProject() {
		List projectList = null;
		try {
			projectList =  projectDAO.listProject();
	      } catch (Exception ex) { 
	     }
		return projectList;
	}

}
