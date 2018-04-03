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
 * @author Dania Tamim
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
        MyFileHandler instance = new MyFileHandler("dania");
        ArrayList<Task> expResult =  new ArrayList<>();
        ArrayList<Task> result = instance.readToDoList();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of saveToDoList method, of class MyFileHandler.
     */
    @Test
    public void testSaveToDoList() {
        System.out.println("saveToDoList");
        ArrayList<Task> tasks =new ArrayList<>();
        MyFileHandler instance = new MyFileHandler("dania");
        instance.saveToDoList(tasks);
      
    }
    
}
