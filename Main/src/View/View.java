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
                + ">> You have   " + contr.numOfNotDoneTask() + "  tasks todo and   " + contr.numOfDoneTask() + "  tasks are done! \n "
                + ">> Pick an option: \n "
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

        if (subMenuNum == 10) {
            switch (input) {
                case 1: {
                    subMenuNum = 1;
                    showTaskMenu();
                    break;
                }
                case 2: {
                    subMenuNum = 2;
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
                    subMenuNum = 0;
                    System.out.println("Enter a valid number from the list please !");

                }
            }
        } else if (subMenuNum == 1) {
            switch (input) {
                case 1: {
                    contr.printToDoList(contr.searchByDueDate(null));
                    break;
                }
                case 2: {
                    contr.printToDoList(contr.searchByProject(null));
                    break;
                }
                default: {

                    System.out.println("Enter a valid number from the list please !");

                }

            }}
        else if (subMenuNum == 3) 
            {
                switch (input) {
                    case 1: {
                        contr.printToDoList(contr.searchByDueDate(null));
                        break;
                    }
                    case 2: {
                        contr.printToDoList(contr.searchByProject(null));
                        break;
                    }
                    default: {

                        System.out.println("Enter a valid number from the list please !");

                    }
                }

            }

        }
    

    public void printToDoList() {

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
        } catch (ParseException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void showUpdateTaskMenu() {
        System.out.println(" \n Edit Task :"
                + "(Update Task "
                + " Mark Task as Done"
                + " Remove Task) \n "
                + ">> \n "
                + ">>  Enter your choice : \n");
    }

    private void showExitMenu() {
        //MyFileHandler myfileHandler=new MyFileHandler();
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
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        Date date = format.parse(dateString);

        return date;

    }

    private void showTaskMenu() {

        System.out.println(" \n "
                + ">> (1) Show Task List by date  \n "
                + ">> (2) Show Task List by project \n "
                + ">> \n "
                + ">>  Enter your choice : \n");
        int choice = getUserInput();
        parseUserInput(choice);

//        if (choice == 1) {
//            // searchTaskList_byDueDate
//
//        } else if (choice == 2) {
//            //searchTaskList_byProject
//        }
    }

}
