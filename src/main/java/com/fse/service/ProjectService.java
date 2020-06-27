package com.fse.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fse.bean.ProjectManagerBean;

@Service
public interface ProjectService {
	public void addProject(ProjectManagerBean projectManagerBean);
	public void updateProject(ProjectManagerBean projectManagerBean);
	public void suspendProject(int projectId);
	public List listProject();
}
