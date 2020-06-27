package com.fse.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.fse.bean.ProjectManagerBean;
import com.fse.hibernate.Project;

@Repository
public interface ProjectDAO {
	
	public void addProject(ProjectManagerBean projectManagerBean);
	public void updateProject(ProjectManagerBean projectManagerBean);
	public void suspendProject(int projectId);
	public List listProject();
	public Project getProject(int projectId);
}
