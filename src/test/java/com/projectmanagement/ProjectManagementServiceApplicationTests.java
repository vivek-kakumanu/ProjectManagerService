package com.projectmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.projectmanagement.dao.TaskDaoImpl;
import com.projectmanagement.restservice.TaskManagementRestfulService;
import com.projectmanagement.model.ParentTask;
import com.projectmanagement.model.Task;


@SpringBootTest
class ProjectManagementServiceApplicationTests {

	@InjectMocks
	TaskManagementRestfulService taskService;
     
    @Mock
    TaskDaoImpl taskDao;
     
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
 
        when(taskDao.getTasks()).thenReturn(list);
 
        // when
        List<Task> result = taskDao.getTasks();
 
        // then
        assertEquals(result.size(), list.size());
        assertEquals(result.get(0).getTaskName(), list.get(0).getTaskName());
    }
}
