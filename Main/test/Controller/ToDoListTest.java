/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Task;
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
 * @author tmp-sda-1171
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
     * Test of getName method, of class ToDoList.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        ToDoList instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class ToDoList.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        ToDoList instance = null;
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTasks method, of class ToDoList.
     */
    @Test
    public void testGetTasks() {
        System.out.println("getTasks");
        ToDoList instance = null;
        ArrayList<Task> expResult = null;
        ArrayList<Task> result = instance.getTasks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTasks method, of class ToDoList.
     */
    @Test
    public void testSetTasks() {
        System.out.println("setTasks");
        ArrayList<Task> tasks = null;
        ToDoList instance = null;
        instance.setTasks(tasks);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTask method, of class ToDoList.
     */
    @Test
    public void testAddTask() {
        System.out.println("addTask");
        Task task = null;
        ToDoList instance = null;
        instance.addTask(task);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        ToDoList instance = null;
        instance.updateTask(index, newTitle, newDate, newProject);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTaskDone method, of class ToDoList.
     */
    @Test
    public void testSetTaskDone() {
        System.out.println("setTaskDone");
        Task task = null;
        ToDoList instance = null;
        instance.setTaskDone(task);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeTask method, of class ToDoList.
     */
    @Test
    public void testRemoveTask() {
        System.out.println("removeTask");
        Task task = null;
        ToDoList instance = null;
        instance.removeTask(task);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByProject method, of class ToDoList.
     */
    @Test
    public void testSearchByProject() {
        System.out.println("searchByProject");
        String project = "";
        ToDoList instance = null;
        ArrayList<Task> expResult = null;
        ArrayList<Task> result = instance.searchByProject(project);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByDueDate method, of class ToDoList.
     */
    @Test
    public void testSearchByDueDate() {
        System.out.println("searchByDueDate");
        Date dueDate = null;
        ToDoList instance = null;
        ArrayList<Task> expResult = null;
        ArrayList<Task> result = instance.searchByDueDate(dueDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveToDoList method, of class ToDoList.
     */
    @Test
    public void testSaveToDoList() {
        System.out.println("saveToDoList");
        ToDoList instance = null;
        instance.saveToDoList();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readToDoList method, of class ToDoList.
     */
    @Test
    public void testReadToDoList() {
        System.out.println("readToDoList");
        ToDoList instance = null;
        ArrayList<Task> expResult = null;
        ArrayList<Task> result = instance.readToDoList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of numOfDoneTask method, of class ToDoList.
     */
    @Test
    public void testNumOfDoneTask() {
        System.out.println("numOfDoneTask");
        ToDoList instance = null;
        int expResult = 0;
        int result = instance.numOfDoneTask();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of numOfNotDoneTask method, of class ToDoList.
     */
    @Test
    public void testNumOfNotDoneTask() {
        System.out.println("numOfNotDoneTask");
        ToDoList instance = null;
        int expResult = 0;
        int result = instance.numOfNotDoneTask();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sortByDueDate method, of class ToDoList.
     */
    @Test
    public void testSortByDueDate_ArrayList() {
        System.out.println("sortByDueDate");
        ArrayList<Task> list = null;
        ToDoList instance = null;
        ArrayList<Task> expResult = null;
        ArrayList<Task> result = instance.sortByDueDate(list);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sortByDueDate method, of class ToDoList.
     */
    @Test
    public void testSortByDueDate_0args() {
        System.out.println("sortByDueDate");
        ToDoList instance = null;
        ArrayList<Task> expResult = null;
        ArrayList<Task> result = instance.sortByDueDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sortByProject method, of class ToDoList.
     */
    @Test
    public void testSortByProject() {
        System.out.println("sortByProject");
        ToDoList instance = null;
        ArrayList<Task> expResult = null;
        ArrayList<Task> result = instance.sortByProject();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
