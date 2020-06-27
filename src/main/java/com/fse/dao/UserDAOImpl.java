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
import com.fse.hibernate.Project;
import com.fse.hibernate.Task;
import com.fse.hibernate.User;

@Repository
public class UserDAOImpl implements UserDAO{
	
	private static SessionFactory factory; 
 
	@Autowired
	ProjectDAO projectDAO = null;
	
	@Autowired
	TaskDAO taskDAO = null;
	
	public void addUser(ProjectManagerBean projectManagerBean) {
		Session session = factory.openSession();
	      Transaction tx = null;
	      User user = null;
	      try {
	         tx = session.beginTransaction();
	         user.setFirstName(projectManagerBean.getFirstName());
	         user.setLastName(projectManagerBean.getLastName());
	         user.setEmployeeId(projectManagerBean.getEmployeeId());
	         Project project = projectDAO.getProject(projectManagerBean.getProjectId());
	         Task task = taskDAO.getTask(projectManagerBean.getTaskId());
	         user.setTask(task);
	         user.setProject(project);
	         session.save(user); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	      } finally {
	         session.close(); 
	      }
	}

	public User editUser(ProjectManagerBean projectManagerBean) {
		Session session = factory.openSession();
	      Transaction tx = null;
	      User user = null;
	      try {
	         tx = session.beginTransaction();
	         user = (User)session.get(User.class, projectManagerBean.getUserId());
        	 Project project = (Project)session.get(Project.class, projectManagerBean.getProjectId());
        	 if(project != null)
	        	 user.setProject(project);
        	 Task task = (Task)session.get(Task.class, projectManagerBean.getTaskId());
        	 if(task != null)
	        	 user.setTask(task); 
			 session.update(user); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	      } finally {
	         session.close(); 
	      }
		return user;
	}

	public void deleteUser(int userId) {
		Session session = factory.openSession();
	      Transaction tx = null;
	      User user = null;
	      try {
	         tx = session.beginTransaction();
	         user = (User)session.get(User.class, userId); 
			 session.delete(user); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	      } finally {
	         session.close(); 
	      }
	}
	
   public List listUser()
   		{
	      Session session = factory.openSession();
	      Transaction tx = null;
	      List userList = null;
	      ProjectManagerBean projectManagerBean = null;
	      try {
		         tx = session.beginTransaction();
		         userList = session.createQuery("FROM User").list(); 
		         for (Iterator iterator = userList.iterator(); iterator.hasNext();){
			        	 projectManagerBean = new ProjectManagerBean();
			        	 User user = (User) iterator.next(); 
				         projectManagerBean.setFirstName(user.getFirstName());
				         projectManagerBean.setLastName(user.getLastName());
				         projectManagerBean.setEmployeeId(user.getEmployeeId());
				         userList.add(projectManagerBean);
			       }
			         tx.commit();
		    } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		    } finally {
		         session.close(); 
		    }
		    return userList;
		}
   
	public User getUser(int userId) {
		Session session = factory.openSession();
	      Transaction tx = null;
	      User user = null;
	      try {
	         tx = session.beginTransaction();
	         user = (User)session.get(User.class, userId);
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	      } finally {
	         session.close(); 
	      }
		return user;
	}
}
