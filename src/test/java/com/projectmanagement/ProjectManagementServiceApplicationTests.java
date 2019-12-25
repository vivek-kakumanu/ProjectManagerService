package com.projectmanagement;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.projectmanagement.dao.TaskDaoImpl;
import com.projectmanagement.restservice.TaskManagementRestfulService;


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
}
