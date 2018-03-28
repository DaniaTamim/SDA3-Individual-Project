package View;

import Controller.ToDoList;
import Model.Task;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tmp-sda-1171
 */
public class View {

    private static int subMenuNum = 10;
    private ToDoList contr;

    public View(ToDoList contr) {
        this.contr = contr;
    }

    public void printWelcome() {

        System.out.println(">> Welcome to ToDoly \n "
                + ">> You have   " + contr.numOfNotDoneTask() + "  tasks todo and   " + contr.numOfDoneTask() + "  tasks are done! \n ");

    }

    public void printMenu() {
        if (subMenuNum == 10)

        System.out.println(">> Pick an option: \n "
                + ">> (1) Show Task List (by date or project) \n "
                + ">> (2) Add New Task \n "
                + ">> (3) Edit Task (update, mark as done, remove) \n "
                + ">> (4) Save and Quit  \n "
                + ">> \n "
                + ">>  Enter your choice : \n");

    }

    public int getUserInput() {

        int userInput = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            userInput = scanner.nextInt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return userInput;
    }

    public void parseUserInput(int input) {

        switch (subMenuNum) {
            case 10:
            {
                switch (input) {
                    case 1: {
                        subMenuNum = 1;
                        showTaskMenu();
                        break;
                    }
                    case 2: {
                        subMenuNum = 10;
                        showAddTaskMenu();
                        break;
                    }
                    case 3: {
                        subMenuNum = 3;
                        showUpdateTaskMenu();
                        
                        break;
                    }
                    case 4: {
                        subMenuNum = 4;
                        showExitMenu();
                        break;
                    }

                    default: {
                        subMenuNum = 10;
                        System.out.println("HHSDFHDFHA Enter a valid number from the list please !");
                        break;

                    }
                }
                break;
            }
            case 1:
                switch (input) {
                    case 1: {
                        
                        System.out.println("Date Sorted");
                        printToDoList(contr.sortByDueDate());
                        subMenuNum = 10;
                        break;
                    }
                    case 2: {
                        System.out.println("Project Sorted");
                        printToDoList(contr.sortByProject());
                        subMenuNum = 10;
                        break;
                    }
                    case 0: {
                        subMenuNum = 10;
                        printMenu();
                        break;
                    }
                    default: {
                        subMenuNum = 1;
                        System.out.println("Enter a valid number from the list please !");
                        break;
                    }

                }
                break;
            case 3:
                switch (input) {
                    case 1: {
                        //updatetask
                        //contr.printToDoList(contr.searchByDueDate(null));
                        subMenuNum = 10;
                        break;
                    }
                    case 2: {
                        //contr.setTaskDone(task);
                        subMenuNum = 10;
                        break;
                    }
                    case 3: {
                        // contr.removeTask(task);
                        subMenuNum = 10;
                    }
                    case 0: {
                        subMenuNum = 10;
                        printMenu();
                        break;
                    }
                    default: {
                        System.out.println("Enter a valid number from the list please !");
                        break;

                    }
                }
                break;
            case 4:{
                System.exit(0);
                break;
            }
            default:
                break;
        }

    }

    public void printToDoList(ArrayList<Task> tasks) {
        
        
            for (int i=0 ; i< tasks.size();i++)
            {
            System.out.println("("+i+")" +  tasks.get(i).toString());
            }
        
            parseUserInput(getUserInput());
            
      

    }

    private void showAddTaskMenu() {

        try {
            System.out.println(" \n  >> (2) Add New Task \n ");
            System.out.println("Enter Title :\n ");
            String title = readText();

            System.out.println("Enter Project :\n ");
            String project = readText();

            System.out.println("Enter Due Date :\n ");

            Date dueDate = stringToDate(readText());

            Task newtask = new Task(title, dueDate, project);

            contr.addTask(newtask);

            System.out.println("Task Added \n ");
            // System.out.println(newtask.toString());
            printMenu();

        } catch (ParseException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void showUpdateTaskMenu() {
        System.out.println(" \n Edit Task :"
                + ">> (1) Update Task "
                + ">> (2) Mark Task as Done"
                + ">> (3) Remove Task) \n "
                 + ">> (0) To Go Back \n "
                + ">> \n "
                + ">>  Enter your choice : \n");
        parseUserInput(getUserInput());
    }

    private void showExitMenu() {
        contr.saveToDoList();
        System.out.println(">> \n "
                + ">> Good Bye .. Have A Nice Day "
                + " Saving . . . and Exit  \n "
                + ">> \n ");
        // myfileHandler.saveFile();
        // exit program
    }

    // Read text from user :
    public String readText() {

        String userInput = "";
        try {
            Scanner scanner = new Scanner(System.in);
            userInput = scanner.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return userInput;
    }

    public Date stringToDate(String dateString) throws ParseException {
        //String string = "January 2, 2010";
        DateFormat format = new SimpleDateFormat("DD-MM-yyyy");
        Date date = format.parse(dateString);

        return date;

    }

    private void showTaskMenu() {

        System.out.println(" \n "
                + ">> (1) Show Task List by date  \n "
                + ">> (2) Show Task List by project \n "
                + ">> (0) To Go Back \n "
                + ">> \n "
                + ">>  Enter your choice : \n");
       parseUserInput(getUserInput());

    }

}
