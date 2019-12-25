package com.projectmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.projectmanagement.dao.ProjectManagerDaoImpl;
import com.projectmanagement.restservice.TaskManagementRestfulService;
import com.projectmanagement.model.Project;
import com.projectmanagement.model.User;
import com.projectmanagement.model.ParentTask;
import com.projectmanagement.model.Task;


@SpringBootTest
class ProjectManagementServiceApplicationTests {

	@InjectMocks
	TaskManagementRestfulService taskService;
     
    @Mock
    ProjectManagerDaoImpl projectManagerDao;
     
    /*@Test
    public void testAddTask() 
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
         
        Task task = new Task( new ParentTask("parentTask"),null, "taskname",20,new Date(), new Date(), false);
        when(taskDao.addTask(task)).thenReturn(task);
         
        
        try {
        	Task task1 = taskDao.addTask(task);
        	assertEquals(task, task1);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("The exception is : " + e);
			e.printStackTrace();
		}
        
    }
*/
    @Test
    public void testGetTasks() 
    {
        // given
    	Task task1 = new Task( new ParentTask("parentTestTask"),null, "Testtaskname",20,new Date(), new Date(), false);
    	Task task2 = new Task( new ParentTask("parentTestTask1"),null, "Testtaskname1",20,new Date(), new Date(), false);
        ArrayList<Task> list = new ArrayList<Task>();
        list.add(task1);
        list.add(task2);
 
        when(projectManagerDao.getTasks()).thenReturn(list);
 
        // when
        List<Task> result = projectManagerDao.getTasks();
 
        // then
        assertEquals(result.size(), list.size());
        assertEquals(result.get(0).getTaskName(), list.get(0).getTaskName());
    }
    
    @Test
    public void testGetUsers() 
    {
        // given
    	User user = new User(1,"User", "Name",123654);
    	User user1 = new User(2,"Test", "User", 788945);
        ArrayList<User> list = new ArrayList<User>();
        list.add(user);
        list.add(user1);
 
        when(projectManagerDao.getUsers()).thenReturn(list);
 
        // when
        List<User> result = projectManagerDao.getUsers();
 
        // then
        assertEquals(result.size(), list.size());
        assertEquals(result.get(0).getFirstName(), list.get(0).getFirstName());
    }
    @Test
    public void testGetProjects() throws ParseException 
    {
        // given
    	Project project = new Project("Acis", new Date(),new Date(), 2);
    	Project project1 = new Project("Project", new SimpleDateFormat("yyyy-MM-dd").parse("2018-11-26"), new SimpleDateFormat("yyyy-MM-dd").parse("2017-11-28"), 2);
        ArrayList<Project> list = new ArrayList<Project>();
        list.add(project);
        list.add(project1);
 
        when(projectManagerDao.getProjects()).thenReturn(list);
 
        // when
        List<Project> result = projectManagerDao.getProjects();
 
        // then
        assertEquals(result.size(), list.size());
        assertEquals(result.get(0).getProjectName(), list.get(0).getProjectName());
    }
    
}
