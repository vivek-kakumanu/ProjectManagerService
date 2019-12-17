package com.taskmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.taskmanagement.model.ParentTask;
import com.taskmanagement.model.Project;
import com.taskmanagement.model.Task;
import com.taskmanagement.model.User;


@Repository
public class TaskDaoImpl implements TaskDao {

	/** Initialize the LOGGER object */
	private static final Log logger = LogFactory.getLog(TaskDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User addTask(User task) {
		// TODO Auto-generated method stub
		logger.info("Inserting Task and Parent in database");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.update(task);
			tx.commit();

		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			logger.error("Exception while inserting the task: " + ex);
			throw ex;
		} finally {
			session.close();
		}
		logger.info("Task Added Successfully.");
		return task;

	}

	@Override
	public Task updateTask(Task task) {
		// TODO Auto-generated method stub
		logger.info("Updating Task and Parent");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(task);
			tx.commit();

		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			logger.error("Exception while updating the task: " + ex);
			throw ex;
		} finally {
			session.close();
		}
		logger.info("Task Updated Successfully.");
		return task;

	}

	@Override
	public List<Task> getTasks() {
		// TODO Auto-generated method stub
		logger.info("Getting List of Tasks From The Database");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Task> taskList = new ArrayList<Task>();
		try {
			tx = session.beginTransaction();
			taskList = session.createQuery("from Task" ,Task.class).list();
			tx.commit();

		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			logger.error("Exception while retrieving the task list : " + ex);
			throw ex;
		} finally {
			session.close();
		}
		logger.info("Tasks List Retrieved Successfully.");
		return taskList;
	}

	@Override
	public Task getTask(int id) {
		// TODO Auto-generated method stub
		logger.info("Getting a Task Based on The Key Passed");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Task task = new Task();
		try {
			tx = session.beginTransaction();
			task = session.get(Task.class, new Long(id));
			tx.commit();

		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			logger.error("Exception while retrieving the task: " + ex);
			throw ex;
		} finally {
			session.close();
		}
		logger.info("Task Retrieved Successfully from the Database");
		return task;
	}

	@Override
	public User addUser(@Valid User user) {
		// TODO Auto-generated method stub		
		logger.info("Inserting User in database");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		User modUser = new User(user.getUserId(),user.getFirstName(),user.getLastName(),user.getEmployeeId());
		
		try {
			tx = session.beginTransaction();
			session.save("user_table",modUser);
			tx.commit();

		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			logger.error("Exception while inserting the user: " + ex);
			throw ex;
		} finally {
			session.close();
		}
		logger.info("User Added Successfully.");
		return modUser;
	}

	@Override
	public User deleteUser(@Valid User user) {
		// TODO Auto-generated method stub		
		logger.info("Deleting User in database");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.delete(user);
			tx.commit();

		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			logger.error("Exception while deleting the user: " + ex);
			throw ex;
		} finally {
			session.close();
		}
		logger.info("User Deleted Successfully.");
		return user;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		logger.info("Getting List of Users From The Database");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<User> userList = new ArrayList<User>();
		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(User.class)
				    .setProjection(Projections.projectionList()
				      .add(Projections.property("userId"), "userId")
				      .add(Projections.property("firstName"), "firstName")
				      .add(Projections.property("lastName"), "lastName")
				      .add(Projections.property("employeeId"), "employeeId")
				      .add(Projections.property("project"), "project"))
				    .setResultTransformer(Transformers.aliasToBean(User.class));
			userList = cr.list();
			tx.commit();

		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			logger.error("Exception while retrieving the user list : " + ex);
			throw ex;
		} finally {
			session.close();
		}
		logger.info("Users List Retrieved Successfully.");
		return userList;
	}

	@Override
	public User addProject(@Valid User user) {
		// TODO Auto-generated method stub
		logger.info("Updating User and Project");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		User modUser = new User(user.getUserId(),user.getFirstName(),user.getLastName(),user.getEmployeeId(),user.getProject());
		try {
			tx = session.beginTransaction();
			session.update(modUser);
			tx.commit();

		} catch (Exception ex) {
				if (tx != null)
				tx.rollback();
			logger.error("Exception while updating the User Project: " + ex);
		} finally {
			session.close();
		}
		logger.info("User Updated Successfully.");
		return modUser;

	}

	@Override
	public Project updateProject(@Valid Project project) {
		// TODO Auto-generated method stub
		logger.info("Updating Project");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(project);
			tx.commit();

		} catch (Exception ex) {
				if (tx != null)
				tx.rollback();
			logger.error("Exception while updating the User Project: " + ex);
		} finally {
			session.close();
		}
		logger.info("Project Updated Successfully.");
		return project;

	}
	@Override
	public List<Project> getProjects() {
		// TODO Auto-generated method stub
		logger.info("Getting List of Projects From The Database");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Project> projectList = new ArrayList<Project>();
		try {
			tx = session.beginTransaction();
			projectList = session.createQuery("from Project", Project.class).list();
			tx.commit();

		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			logger.error("Exception while retrieving the project list : " + ex);
			throw ex;
		} finally {
			session.close();
		}
		logger.info("Projects List Retrieved Successfully.");
		return projectList;
	}
	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		logger.info("Getting a User Based on The Key Passed");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		User user = new User();
		try {
			tx = session.beginTransaction();
			user = session.get(User.class, new Long(id));
			tx.commit();

		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			logger.error("Exception while retrieving the user: " + ex);
			throw ex;
		} finally {
			session.close();
		}
		logger.info("User Retrieved Successfully from the Database");
		return user;
	}
	
	@Override
	public User updateUser(@Valid User user) {
		// TODO Auto-generated method stub
		logger.info("Updating User");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(user);
			tx.commit();

		} catch (Exception ex) {
				if (tx != null)
				tx.rollback();
			logger.error("Exception while updating the User Project: " + ex);
		} finally {
			session.close();
		}
		logger.info("User Updated Successfully.");
		return user;

	}

	@Override
	public List<ParentTask> getParentTasks() {
		// TODO Auto-generated method stub
		logger.info("Getting List of Parent Tasks From The Database");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<ParentTask> parentList = new ArrayList<ParentTask>();
		try {
			tx = session.beginTransaction();
			parentList = session.createQuery("from ParentTask", ParentTask.class).list();
			tx.commit();

		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			logger.error("Exception while retrieving the Parent Tasks list : " + ex);
			throw ex;
		} finally {
			session.close();
		}
		logger.info("Parent Tasks List Retrieved Successfully.");
		return parentList;
	}
	}

