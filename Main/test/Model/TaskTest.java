/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
        Task instance = null;
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTitle method, of class Task.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String Title = "";
        Task instance = null;
        instance.setTitle(Title);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDueDate method, of class Task.
     */
    @Test
    public void testGetDueDate() {
        System.out.println("getDueDate");
        Task instance = null;
        Date expResult = null;
        Date result = instance.getDueDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDueDate method, of class Task.
     */
    @Test
    public void testSetDueDate() {
        System.out.println("setDueDate");
        Date dueDate = null;
        Task instance = null;
        instance.setDueDate(dueDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isIsDone method, of class Task.
     */
    @Test
    public void testIsIsDone() {
        System.out.println("isIsDone");
        Task instance = null;
        boolean expResult = false;
        boolean result = instance.isIsDone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIsDone method, of class Task.
     */
    @Test
    public void testSetIsDone() {
        System.out.println("setIsDone");
        boolean isDone = false;
        Task instance = null;
        instance.setIsDone(isDone);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProject method, of class Task.
     */
    @Test
    public void testGetProject() {
        System.out.println("getProject");
        Task instance = null;
        String expResult = "";
        String result = instance.getProject();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProject method, of class Task.
     */
    @Test
    public void testSetProject() {
        System.out.println("setProject");
        String project = "";
        Task instance = null;
        instance.setProject(project);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTask method, of class Task.
     */
    @Test
    public void testAddTask() {
        System.out.println("addTask");
        String title = "";
        Date dutDate = null;
        String project = "";
        Task instance = null;
        Task expResult = null;
        Task result = instance.addTask(title, dutDate, project);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateTask method, of class Task.
     */
    @Test
    public void testUpdateTask() {
        System.out.println("updateTask");
        String title = "";
        Date dutDate = null;
        boolean isdone = false;
        String project = "";
        Task instance = null;
        Task expResult = null;
        Task result = instance.updateTask(title, dutDate, isdone, project);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of markAsDone method, of class Task.
     */
    @Test
    public void testMarkAsDone() {
        System.out.println("markAsDone");
        Task task = null;
        Task instance = null;
        instance.markAsDone(task);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Task.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Task instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class Task.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Object task = null;
        Task instance = null;
        int expResult = 0;
        int result = instance.compareTo(task);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
