/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Task;
import java.util.ArrayList;
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
public class MyFileHandlerTest {
    
    public MyFileHandlerTest() {
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
     * Test of readToDoList method, of class MyFileHandler.
     */
    @Test
    public void testReadToDoList() {
        System.out.println("readToDoList");
        MyFileHandler instance = null;
        ArrayList<Task> expResult = null;
        ArrayList<Task> result = instance.readToDoList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveToDoList method, of class MyFileHandler.
     */
    @Test
    public void testSaveToDoList() {
        System.out.println("saveToDoList");
        ArrayList<Task> tasks = null;
        MyFileHandler instance = null;
        instance.saveToDoList(tasks);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
