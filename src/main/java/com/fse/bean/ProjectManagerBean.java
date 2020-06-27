package com.fse.bean;

import java.util.Date;

public class ProjectManagerBean {
	
	private int parentId;
	private String parentTask;
	private int taskId;
	private String task;
	private Date taskStartDate;
	private Date taskEndDate;
	private int taskPriority;
	private String taskStatus;
	private int projectId;
	private String project;
	private Date projectStartDate;
	private Date projectEndDate;
	private int projectPriority;
	private int userId;
	private String firstName;
	private String lastName;
	private int employeeId;
	private int totalNoOfTask;
	private int totalTaskCompleted;
	
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getParentTask() {
		return parentTask;
	}
	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public Date getTaskStartDate() {
		return taskStartDate;
	}
	public void setTaskStartDate(Date taskStartDate) {
		this.taskStartDate = taskStartDate;
	}
	public Date getTaskEndDate() {
		return taskEndDate;
	}
	public void setTaskEndDate(Date taskEndDate) {
		this.taskEndDate = taskEndDate;
	}
	public int getTaskPriority() {
		return taskPriority;
	}
	public void setTaskPriority(int taskPriority) {
		this.taskPriority = taskPriority;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public Date getProjectStartDate() {
		return projectStartDate;
	}
	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}
	public Date getProjectEndDate() {
		return projectEndDate;
	}
	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}
	public int getProjectPriority() {
		return projectPriority;
	}
	public void setProjectPriority(int projectPriority) {
		this.projectPriority = projectPriority;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	public int getTotalNoOfTask() {
		return totalNoOfTask;
	}
	public void setTotalNoOfTask(int totalNoOfTask) {
		this.totalNoOfTask = totalNoOfTask;
	}
	public int getTotalTaskCompleted() {
		return totalTaskCompleted;
	}
	public void setTotalTaskCompleted(int totalTaskCompleted) {
		this.totalTaskCompleted = totalTaskCompleted;
	}
}
