package com.fse.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.fse.bean.ProjectManagerBean;
import com.fse.hibernate.Project;
import com.fse.hibernate.Task;

@Repository
public class ProjectDAOImpl implements ProjectDAO {
	
	private static SessionFactory factory; 
	
	@Autowired
	TaskDAO taskDAO;
	
	@Autowired
	UserDAO userDAO;

	public void addProject(ProjectManagerBean projectManagerBean) {
		Session session = factory.openSession();
	    Transaction tx = null;
	    Project project = null;  
	      try {
	         tx = session.beginTransaction();
	         project = new Project();
	         project.setProject(projectManagerBean.getProject());
	         project.setStartDate(projectManagerBean.getProjectStartDate());
	         project.setEndDate(projectManagerBean.getProjectEndDate());
	         project.setPriority(projectManagerBean.getProjectPriority());
	         userDAO.editUser(projectManagerBean);
	         session.save(project); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	      } finally {
	         session.close(); 
	      }
	}

	public void updateProject(ProjectManagerBean projectManagerBean) {
		Session session = factory.openSession();
	      Transaction tx = null;
	      Project project = null;
	      try {
		         tx = session.beginTransaction();
		         project = (Project)session.get(Project.class, projectManagerBean.getProjectId()); 
		         project.setProject(projectManagerBean.getProject());
		         project.setStartDate(projectManagerBean.getProjectStartDate());
		         project.setEndDate(projectManagerBean.getProjectEndDate());
		         project.setPriority(projectManagerBean.getProjectPriority());
				 session.update(project); 
		         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	      } finally {
	         session.close(); 
	      }
	}

	public void suspendProject(int projectId) {
		Session session = factory.openSession();
	      Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	         Project project = (Project)session.get(Project.class, projectId); 
			 session.delete(project); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	      } finally {
	         session.close(); 
	      }
	}
	
	   public List listProject( ){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      List listProject = null;
	      ProjectManagerBean projectManagerBean = null;
	      try {
	         tx = session.beginTransaction();
	         listProject = session.createQuery("FROM Project").list(); 
	         for (Iterator iterator = listProject.iterator(); iterator.hasNext();){
	            projectManagerBean = new ProjectManagerBean();
	            Project project = (Project) iterator.next(); 
	            projectManagerBean.setProject(project.getProject()); 
	            projectManagerBean.setProjectPriority(project.getPriority()); 
	            projectManagerBean.setProjectStartDate(project.getStartDate()); 
	            projectManagerBean.setProjectEndDate(project.getEndDate()); 
	            Set taskSet = project.getTasks();
	            projectManagerBean.setTotalNoOfTask(taskSet.size());
	            Iterator<Task> value = taskSet.iterator(); 
	            int taskCompleted = 0;
	            while (value.hasNext()) { 
	                Task task = value.next(); 
	                if(task.getStatus() == "Completed")
	                	taskCompleted++;
	            } 
	            projectManagerBean.setTotalTaskCompleted(taskCompleted);
	            listProject.add(projectManagerBean);
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	      } finally {
	         session.close(); 
	      }
	      return listProject;
	   }
	   
		public Project getProject(int projectId) {
			Session session = factory.openSession();
		      Transaction tx = null;
		      Project project = null;
		      try {
		         tx = session.beginTransaction();
		         project = (Project)session.get(Project.class, projectId); 
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		      } finally {
		         session.close(); 
		      }
			return project;
		}

}
