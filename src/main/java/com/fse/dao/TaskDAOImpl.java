package com.fse.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fse.bean.ProjectManagerBean;
import com.fse.hibernate.ParentTask;
import com.fse.hibernate.Project;
import com.fse.hibernate.Task;
import com.fse.hibernate.User;

@Repository
public class TaskDAOImpl implements TaskDAO {
	
	@Autowired
	ProjectDAO projectDAO;
	
	@Autowired
	UserDAO userDAO;
	
	private static SessionFactory factory; 

	public void addTask(ProjectManagerBean projectManagerBean) {
		Session session = factory.openSession();
	      Transaction tx = null;
	      Task task = null;
	      ParentTask parentTask = null;
	      Project project = null;
	      User user = null;
	      try {
	    	 task = new Task();
	         tx = session.beginTransaction();
	         parentTask = getParentTask(projectManagerBean.getParentId());
	         project = projectDAO.getProject(projectManagerBean.getProjectId());
	         user = userDAO.getUser(projectManagerBean.getUserId());
	         task.setStartDate(projectManagerBean.getTaskStartDate());
	         task.setEndDate(projectManagerBean.getTaskEndDate());
	         task.setPriority(projectManagerBean.getTaskPriority());
	         task.setStatus(projectManagerBean.getTaskStatus());
	         task.setParentTask(parentTask);
	         task.setProject(project);
	         userDAO.editUser(projectManagerBean);
	         session.save(task); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	      } finally {
	         session.close(); 
	      }
		
	}

	public void editTask(ProjectManagerBean projectManagerBean) {
		Session session = factory.openSession();
	    Transaction tx = null;
	    Task task = null;
	    ParentTask parentTask = null;
	    Project project = null;
	    User user = null;
	      try {
	         tx = session.beginTransaction();
	         task = (Task)session.get(Task.class, projectManagerBean.getTaskId()); 
	         parentTask = getParentTask(projectManagerBean.getParentId());
	         project = projectDAO.getProject(projectManagerBean.getProjectId());
	         user = userDAO.getUser(projectManagerBean.getUserId());
	         task.setStartDate(projectManagerBean.getTaskStartDate());
	         task.setEndDate(projectManagerBean.getTaskEndDate());
	         task.setPriority(projectManagerBean.getTaskPriority());
	         task.setStatus(projectManagerBean.getTaskStatus());
	         task.setParentTask(parentTask);
	         task.setProject(project);
	         userDAO.editUser(projectManagerBean);
			 session.update(task); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	      } finally {
	         session.close(); 
	      }
	}

	public void endTask(int taskId) {
		Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Task task = (Task)session.get(Task.class, taskId); 
			 session.delete(task); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	      } finally {
	         session.close(); 
	      }
	}
	
	   public List listTask(){
		      Session session = factory.openSession();
		      Transaction tx = null;
		      List taskList = null;
		      ProjectManagerBean projectManagerBean = null;
		      try {
		         tx = session.beginTransaction();
		         taskList = session.createQuery("FROM Task").list(); 
		         for (Iterator iterator = taskList.iterator(); iterator.hasNext();){
		        	projectManagerBean = new ProjectManagerBean();
		            Task task = (Task) iterator.next(); 
		            Project project = task.getProject();
		            ParentTask parenTask = task.getParentTask();
		            projectManagerBean.setProject(project.getProject());
		            projectManagerBean.setProjectStartDate(project.getStartDate());
		            projectManagerBean.setProjectEndDate(project.getEndDate());
		            projectManagerBean.setProjectPriority(project.getPriority());
		            projectManagerBean.setTask(task.getTask()); 
		            projectManagerBean.setTaskPriority(task.getPriority()); 
		            projectManagerBean.setTaskStartDate(task.getStartDate()); 
		            projectManagerBean.setTaskEndDate(task.getEndDate());
		            projectManagerBean.setParentTask(parenTask.getParentTask());
		            taskList.add(projectManagerBean);
		         }
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		      } finally {
		         session.close(); 
		      }
		      return taskList;
		   }
	   
		public Task getTask(int taskId) {
			Session session = factory.openSession();
		      Transaction tx = null;
		      Task task = null;
		      try {
		         tx = session.beginTransaction();
		         task = (Task)session.get(Task.class, taskId);
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		      } finally {
		         session.close(); 
		      }
			return task;
		}
		
		public ParentTask getParentTask(int parentId) {
			Session session = factory.openSession();
		      Transaction tx = null;
		      ParentTask parentTask = null;
		      try {
		         tx = session.beginTransaction();
		         parentTask = (ParentTask)session.get(ParentTask.class, parentId); 
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		      } finally {
		         session.close(); 
		      }
			return parentTask;
		}
}
