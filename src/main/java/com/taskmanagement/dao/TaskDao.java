package com.taskmanagement.dao;

import java.util.List;

import com.taskmanagement.model.ParentTask;
import com.taskmanagement.model.Project;
import com.taskmanagement.model.Task;
import com.taskmanagement.model.User;

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

}
