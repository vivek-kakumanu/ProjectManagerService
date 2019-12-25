package com.projectmanagement.restservice;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectmanagement.dao.ProjectManagerDaoImpl;
import com.projectmanagement.model.ParentTask;
import com.projectmanagement.model.Project;
import com.projectmanagement.model.Task;
import com.projectmanagement.model.User;


@CrossOrigin(
	    allowCredentials = "true",
	    origins = "http://localhost:4200", 
	    allowedHeaders = "*", 
	    methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT}
	)
 
@RestController
@RequestMapping("/taskmanagementservice")
public class TaskManagementRestfulService {

	@Autowired
	private ProjectManagerDaoImpl projectManagerDaoImpl;
	
	
	@PutMapping(value = "/addtask", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User addTask(@Valid @RequestBody User task) {

		return projectManagerDaoImpl.addTask(task);
	}
	@PutMapping(value = "/addUser", produces = MediaType.APPLICATION_JSON_VALUE)
	
	public User addUser(@Valid @RequestBody User user) {

		return projectManagerDaoImpl.addUser(user);
	}
	
	@PutMapping(value = "/deleteUser", produces = MediaType.APPLICATION_JSON_VALUE)
	
	public User deleteUser(@Valid @RequestBody User user) {

		return projectManagerDaoImpl.deleteUser(user);
	}
	
	@PutMapping(value = "/addProject", produces = MediaType.APPLICATION_JSON_VALUE)
	public User addProject(@Valid @RequestBody User user) {
		
		return projectManagerDaoImpl.addProject(user);
	}
	
	@PutMapping(value = "/updateProject", produces = MediaType.APPLICATION_JSON_VALUE)
	public Project updateProject(@Valid @RequestBody Project project) {
		
		return projectManagerDaoImpl.updateProject(project);
	}
	
	@GetMapping(value = "/projects", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Project> getProjects() {
		
		List<Project> projectList = new ArrayList<Project>();
		projectList = projectManagerDaoImpl.getProjects();
		return projectList;
	}

	
	@GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getUsers() {
		
		List<User> userList = new ArrayList<User>();
		userList = projectManagerDaoImpl.getUsers();
		return userList;
	}

	@PutMapping(value = "/updatetask", produces = MediaType.APPLICATION_JSON_VALUE)
	public Task updateTask(@Valid @RequestBody Task task) {
		
		return projectManagerDaoImpl.updateTask(task);
	}

	@GetMapping(value = "/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Task> getTasks() {
		
		List<Task> taskList = new ArrayList<Task>();
		taskList = projectManagerDaoImpl.getTasks();
		return taskList;
	}
	
	@GetMapping(value = "/parentTasks", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ParentTask> getParentTasks() {
		
		List<ParentTask> taskList = new ArrayList<ParentTask>();
		taskList = projectManagerDaoImpl.getParentTasks();
		return taskList;
	}
	
	@GetMapping(value = "/task/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Task getTask(@PathVariable int id) {
		
		Task task = new Task();
		task = projectManagerDaoImpl.getTask(id);
		return task;
}
	@GetMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUser(@PathVariable int id) {
		
		User user = new User();
		user = projectManagerDaoImpl.getUser(id);
		return user;
}
	@GetMapping(value = "/project/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Project getProject(@PathVariable int id) {
		
		Project project = new Project();
		project = projectManagerDaoImpl.getProject(id);
		return project;
}
	
	@PutMapping(value = "/updateUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public User updateUser(@Valid @RequestBody User user) {
		
		return projectManagerDaoImpl.updateUser(user);
	}
}
