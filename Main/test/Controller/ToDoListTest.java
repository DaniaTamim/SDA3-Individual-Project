/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data.MyFileHandler;
import Model.Task;
import java.io.IOException;
import java.util.ArrayList;
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
public class ToDoListTest {
    
    public ToDoListTest() {
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
     * Test of addTask method, of class ToDoList.
     */
    @Test
    public void testAddTaskOneElement() throws IOException {
        System.out.println("addTaskOneElement");
        Date date= new Date();
        Task task = new Task("Task",date,"project");
        ToDoList instance = new ToDoList("Dania");
        instance.addTask(task);
        int expResult= 1;
        int result = instance.getTasks().size();
        assertEquals(expResult, result);
    }

    
        /**
     * Test of addTask method, of class ToDoList.
     */
    @Test
    public void testAddTaskTwoElements() {
        System.out.println("addTaskTwoElements");
        Date date= new Date();
        Task task1 = new Task("Task",date,"project");
        Task task2 = new Task("Task",date,"project");
        ToDoList instance = new ToDoList("Dania");
        instance.addTask(task1);
        instance.addTask(task2);
        int expResult= 2;
        int result = instance.getTasks().size();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of updateTask method, of class ToDoList.
     */
    @Test
    public void testUpdateTask() {
        System.out.println("updateTask");
        int index = 0;
        String newTitle = "";
        Date newDate = null;
        String newProject = "";
        ToDoList instance = new ToDoList("Dania");
        instance.updateTask(index, newTitle, newDate, newProject);
       
    }

    /**
     * Test of setTaskDone method, of class ToDoList.
     */
    @Test
    public void testSetTaskDone() {
        System.out.println("setTaskDone");
        Task task = new Task("Task",new Date(),"project");
        ToDoList instance = new ToDoList("Dania");
        instance.addTask(task);
        instance.setTaskDone(task);
       
    }

    /**
     * Test of removeTask method, of class ToDoList.
     */
    @Test
    public void testRemoveTask() {
        System.out.println("removeTask");
        Task task = new Task("Task",new Date(),"project");
        ToDoList instance = new ToDoList("Dania");
        instance.addTask(task);
        instance.removeTask(task);
    
    }

    /**
     * Test of searchByProject method, of class ToDoList.
     */
    @Test
    public void testSearchByProjectEmptyList() {
        System.out.println("searchByProjectEmptyList");
        String project = "";
        ToDoList instance =  new ToDoList("Dania");
        ArrayList<Task> expResult = null;
        ArrayList<Task> result = instance.searchByProject(project);
        assertEquals(expResult, result);
        
    }
    /**
     * Test of searchByProject method, of class ToDoList.
     */
    @Test
    public void testSearchByProjectNotFound() {
        System.out.println("searchByProjectEmptyListNotFound");
        String project = "";
        ToDoList instance =  new ToDoList("Dania");
        Task task = new Task("Task",new Date(),"project");
         instance.addTask(task);
        ArrayList<Task> expResult = new ArrayList<>();
        ArrayList<Task> result = instance.searchByProject(project);
        assertEquals(expResult, result);
        
    }
    
    
        /**
     * Test of searchByProject method, of class ToDoList.
     */
    @Test
    public void testSearchByProjectFound() {
        System.out.println("searchByProjectEmptyListFound");
        String project = "project";
        ToDoList instance =  new ToDoList("Dania");
        Task task = new Task("Task",new Date(),"project");
         instance.addTask(task);
         
        ArrayList<Task> expResult = new ArrayList<>();
        expResult.add(task);
        ArrayList<Task> result = instance.searchByProject(project);
        assertEquals(expResult, result);
        
    }
    
    
    
    /**
     * Test of searchByDueDate method, of class ToDoList.
     */
    @Test
    public void testSearchByDueDateEmptyList() {
        System.out.println("searchByDueDateEmptyList");
        Date dueDate = null;
       ToDoList instance =  new ToDoList("Dania");
        ArrayList<Task> expResult = null;
        ArrayList<Task> result = instance.searchByDueDate(dueDate);
        assertEquals(expResult, result);
     
        
    }

    /**
     * Test of saveToDoList method, of class ToDoList.
     */
    @Test
    public void testSaveToDoListEmptyList() {
        System.out.println("saveToDoListEmptyList");
        ToDoList instance = new ToDoList("Dania");
        instance.saveToDoList();
        ArrayList<Task> expResult = new ArrayList<>();
        ArrayList<Task> result = instance.readToDoList();
       assertEquals(expResult, result);
    }

    
        /**
     * Test of saveToDoList method, of class ToDoList.
     */
    @Test
    public void testSaveToDoListOneElement() {
        System.out.println("saveToDoListOneElement");
        ToDoList instance = new ToDoList("Dania");
        Task task = new Task("", new Date(), "");
        instance.addTask(task);
        instance.saveToDoList();
        ArrayList<Task> expResult = new ArrayList<>();
        expResult.add(task);
        ArrayList<Task> result = instance.readToDoList();
       assertEquals(expResult.size(), result.size());
    } 
    
//    /**
//     * Test of readToDoList method, of class ToDoList.
//     */
//    @Test
//    public void testReadToDoList() {
//        System.out.println("readToDoList");
//        ToDoList instance = null;
//        ArrayList<Task> expResult = null;
//        ArrayList<Task> result = instance.readToDoList();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of numOfDoneTask method, of class ToDoList.
//     */
//    @Test
//    public void testNumOfDoneTask() {
//        System.out.println("numOfDoneTask");
//        ToDoList instance = null;
//        int expResult = 0;
//        int result = instance.numOfDoneTask();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of numOfNotDoneTask method, of class ToDoList.
//     */
//    @Test
//    public void testNumOfNotDoneTask() {
//        System.out.println("numOfNotDoneTask");
//        ToDoList instance = null;
//        int expResult = 0;
//        int result = instance.numOfNotDoneTask();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of sortByDueDate method, of class ToDoList.
//     */
//    @Test
//    public void testSortByDueDate_ArrayList() {
//        System.out.println("sortByDueDate");
//        ArrayList<Task> list = null;
//        ToDoList instance = null;
//        ArrayList<Task> expResult = null;
//        ArrayList<Task> result = instance.sortByDueDate(list);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of sortByDueDate method, of class ToDoList.
//     */
//    @Test
//    public void testSortByDueDate_0args() {
//        System.out.println("sortByDueDate");
//        ToDoList instance = null;
//        ArrayList<Task> expResult = null;
//        ArrayList<Task> result = instance.sortByDueDate();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of sortByProject method, of class ToDoList.
//     */
//    @Test
//    public void testSortByProject() {
//        System.out.println("sortByProject");
//        ToDoList instance = null;
//        ArrayList<Task> expResult = null;
//        ArrayList<Task> result = instance.sortByProject();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
