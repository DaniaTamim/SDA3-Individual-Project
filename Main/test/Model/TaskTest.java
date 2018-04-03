/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dania Tamim
 */
public class TaskTest {
    
    public TaskTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTitle method, of class Task.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        Date date=new Date();
        Task instance = new Task("Task",date,"project");
        String expResult = "Task";
        String result = instance.getTitle();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setTitle method, of class Task.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
         Date date=new Date();
        Task instance = new Task("Task",date,"project");
        String expResult = "New Title";
        instance.setTitle("New Title");
        assertEquals(expResult, instance.getTitle());
       
    }

  
       
    

 


  
  


    /**
     * Test of updateTask method, of class Task.
     */
    @Test
    public void testUpdateTask() {
        System.out.println("updateTask");
        String title = "New Title";
        Date dueDate = new Date();
        boolean isdone = false;
        String project = "New Project";
   
        Task instance = new Task("title", dueDate, "project");
        instance.updateTask(title, dueDate, isdone, project);
      
        assertEquals(title, instance.getTitle());
        assertEquals(dueDate, instance.getDueDate());
        assertEquals(project, instance.getProject());
        assertEquals(isdone, instance.isIsDone());
 
    }



    /**
     * Test of toString method, of class Task.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Task instance = new Task("Title", new Date(), "Project");
        SimpleDateFormat form = new SimpleDateFormat("dd-MM-yyyy");
        Date date = instance.getDueDate();
        
         String status;
        if (instance.isIsDone() == true) {
            status = "Task is Done ";
        } else {
            status = "Task is NOT Done ";
        }
        
        String expResult = " *   " + instance.getTitle() + "   "
                + "  project is : " + instance.getProject() + "   "
                + " due date is : " + form.format(date) + "   "
                + status + "\n";
        
        String result = instance.toString();
        assertEquals(expResult, result);
        
        
        
        
       
    }

    /**
     * Test of compareTo method, of class Task.
     */
    @Test
    public void testCompareToAreEqual() {
        System.out.println("compareTo");
        Task task1 =  new Task("Title", new Date(), "Project");
        Task instance =new Task("Title", new Date(), "Project");
        int expResult = 0;
        int result = instance.compareTo(task1);
        assertEquals(expResult, result);
        
    }
        /**
     * Test of compareTo method, of class Task.
     */
    @Test
    public void testCompareToAreNotEqual() {
        System.out.println("compareTo");
        Task task1 =  new Task("Title1", new Date(), "Project1");
        Task instance =new Task("Title2", new Date(), "Project2");
        int expResult = 1;
        int result = instance.compareTo(task1);
        assertEquals(expResult, result);
        
    }
}
