package com.projectmanagement.dao;

import java.util.List;

import com.projectmanagement.model.ParentTask;
import com.projectmanagement.model.Project;
import com.projectmanagement.model.Task;
import com.projectmanagement.model.User;

public interface TaskDao {
	
	// Method to add task
	public User addTask(User task);
	
	// Method to update task
	public Task updateTask(Task task);
	
	// Method to get tasks list from the database
	public List<Task> getTasks();
	
	// Method to get task
	public Task getTask(int id);

	public User addUser(User user);

	public List<User> getUsers();

	public User addProject(User user);

	public Project updateProject(Project project);

	public List<Project> getProjects();

	public User deleteUser(User user);

	public User getUser(int id);

	public User updateUser(User user);

	public List<ParentTask> getParentTasks();

	public List<Task> getTasksByProject(Project project);

	public Project getProject(int id);

}
