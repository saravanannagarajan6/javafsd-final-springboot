package com.fse.hibernate;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "TASK")
public class Task {
	
	@Id @GeneratedValue
	@Column(name = "task_id")
	private int taskId;
	
	@Column(name = "task")
	private String task;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "priority")
	private int priority; 
	
	@Column(name = "status")
	private String status; 

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Set<User> users;
    
    @ManyToOne
    private ParentTask parentTask;
    
    @ManyToOne
    private Project project;
    
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public ParentTask getParentTask() {
		return parentTask;
	}

	public void setParentTask(ParentTask parentTask) {
		this.parentTask = parentTask;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
}
