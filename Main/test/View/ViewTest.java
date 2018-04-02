/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ToDoList;
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
 * @author tmp-sda-1171
 */
public class ViewTest {
    ToDoList contr;
    
    public ViewTest() throws IOException {
       contr=new ToDoList("Dania");
    }
    
    @BeforeClass
    public static void setUpClass() throws IOException {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        View viewer = new View(contr);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of printWelcome method, of class View.
     */
    @Test
    public void testPrintWelcome() {
        System.out.println("printWelcome");
        View instance = null;
        instance.printWelcome();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printMenu method, of class View.
     */
    @Test
    public void testPrintMenu() {
        System.out.println("printMenu");
        View instance = null;
        instance.printMenu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserInput method, of class View.
     */
    @Test
    public void testGetUserInput() {
        System.out.println("getUserInput");
        View instance = null;
        int expResult = 0;
        int result = instance.getUserInput();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parseUserInput method, of class View.
     */
    @Test
    public void testParseUserInput() {
        System.out.println("parseUserInput");
        int input = 0;
        View instance = null;
        instance.parseUserInput(input);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printToDoList method, of class View.
     */
    @Test
    public void testPrintToDoList() {
        System.out.println("printToDoList");
        ArrayList<Task> tasks = null;
        View instance = null;
        instance.printToDoList(tasks);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readText method, of class View.
     */
    @Test
    public void testReadText() {
        System.out.println("readText");
        View instance = null;
        String expResult = "";
        String result = instance.readText();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stringToDate method, of class View.
     */
    @Test
    public void testStringToDate() {
        System.out.println("stringToDate");
        String dateString = "03-09-2008";
        View instance = new View(contr);
        Date expResult = new Date(dateString);
        Date result = instance.stringToDate(dateString);
        assertEquals(expResult, result);
        
    }
    
}
