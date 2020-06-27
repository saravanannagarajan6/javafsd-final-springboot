package com.fse.hibernate;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "PROJECT")
public class Project {
	
	@Id @GeneratedValue
	@Column(name = "project_id")
	private int projectId;
	
	@Column(name = "project")
	private String project;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "priority")
	private int priority; 
	
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Set<User> users;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="project_id")
    private Set<Task> tasks;
    
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
	
}
