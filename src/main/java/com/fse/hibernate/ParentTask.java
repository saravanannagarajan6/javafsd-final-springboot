package com.fse.hibernate;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PARENTTASK")
public class ParentTask {
	
	@Id @GeneratedValue
	@Column(name = "parent_id")
	private int parentId;
	
	@Column(name = "parent_task")
	private String parentTask;
	
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="parent_id")
    private Set<Task> tasks;

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

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

}
