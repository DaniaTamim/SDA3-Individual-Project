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

    private static String menuType = "MainMenu";
    private ToDoList contr;

    public View(ToDoList contr) {
        this.contr = contr;
    }

    public void printWelcome() {

        System.out.println(">> Welcome to ToDoly \n "
                + ">> You have   " + contr.numOfNotDoneTask() + "  tasks todo and   " + contr.numOfDoneTask() + "  tasks are done! \n ");

    }

    public void printMenu() {

        System.out.println(">> Pick an option: \n "
                + ">> (1) Show Task List (Sorted by date or project) \n "
                + ">> (2) Add New Task \n "
                + ">> (3) Edit Task (update, mark as done, remove) \n "
                + ">> (4) Search By Project Name \n "
                + ">> (5) Save and Quit  \n "
                + ">> \n "
                + ">>  Enter your choice : \n");
        parseUserInput(getUserInput());

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

        switch (menuType) {
            case "MainMenu": {
                switch (input) {
                    case 1: {
                        menuType = "ShowMenu";
                        showTaskMenu();
                        break;
                    }
                    case 2: {
                       
                        showAddTaskMenu();
                        // menuType = "MainMenu";
                        break;
                    }
                    case 3: {
                        menuType = "EditMenu";
                        showUpdateTaskMenu();

                        break;
                    }
                    case 4: {
                        showSearchMenu();
                        break;
                    }
                    case 5: {
                        showExitMenu();
                        break;
                    }

                    default: {
                        menuType = "MainMenu";
                        System.out.println("MainMenu :: Enter a valid number from the list please !");
                        break;

                    }
                }
                break;
            }
            case "ShowMenu":
                switch (input) {
                    case 1: {
                        
                        menuType = "ShowMenu";
                        showByDate();
                        break;
                    }
                    case 2: {
                        
                        menuType = "ShowMenu";
                        showByProject();
                        break;
                    }
                    case 0: {
                        
                        menuType = "MainMenu";
                        printMenu();
                        break;
                    }
                    default: {
                        menuType = "ShowMenu";
                        System.out.println("Show Menu : : Enter a valid number from the list please !");
                        break;
                    }

                }
                break;
            case "EditMenu":
                switch (input) {
                    case 1: {
                        //updatetask
                        UpdateTasks();
                        menuType = "EditMenu";
                        break;
                    }
                    case 2: {
                        //Set as Done
                        setAsDone();
                        menuType = "EditMenu";
                        break;
                    }
                    case 3: {
                        removeTask();
                        menuType = "EditMenu";
                    }
                    case 0: {
                        printMenu();
                        menuType = "MainMenu";
                       break;
                    }
                    default: {
                        menuType = "EditMenu";
                        System.out.println("Edit Menu : : Enter a valid number from the list please !");
                        break;

                    }
                }
                break;
           
            default:
                menuType = "MainMenu";
                System.out.println("Enter a valid number from the list please !");
                break;
        }

    }

    public void printToDoList(ArrayList<Task> tasks) {

        for (int i = 0; i < tasks.size(); i++) {
            
            System.out.println("(" + i + ")" + tasks.get(i).toString());
        }
        
        System.out.println();

    }

    private void showAddTaskMenu() {

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

    }

    private void showExitMenu() {
        contr.saveToDoList();
        System.out.println(">> \n "
                + ">> Good Bye .. Have A Nice Day "
                + " Saving . . . and Exit  \n "
                + ">> \n ");
        System.exit(0);
        
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

    public Date stringToDate(String dateString) {
        //String string = "January 2, 2010";''
        Date date = null;
        try {
            DateFormat form = new SimpleDateFormat("dd-MM-yyyy");
            date = form.parse(dateString);
        } catch (ParseException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Date date2= (Date)form.format(date);
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

    private void showUpdateTaskMenu() {

        System.out.println(" \n "
                + "Edit Task :  \n"
                + ">> (1) Update Task  \n "
                + ">> (2) Mark Task as Done  \n"
                + ">> (3) Remove Task) \n "
                + ">> (0) To Go Back \n "
                + ">> \n "
                + ">>  Enter your choice : \n");
        parseUserInput(getUserInput());
    }

    private void UpdateTasks() {

        String tmpTitle, newTitle, tmpProject, newProject, tmpDate;
        Date newDate;

        int index = getWantedTaskIndex();

        // edit title
        System.out.println("Enter the new title , or enter no to keep it :");

        tmpTitle = readText();

        if (tmpTitle.equals("no")) {

            newTitle = contr.getTasks().get(index).getTitle();
        } else {
            newTitle = tmpTitle;

        }
         //edit Project
        System.out.println("Enter the new project , or enter no to keep it :");

        tmpProject = readText();

        if (tmpProject.equals("no")) {

            newProject = contr.getTasks().get(index).getProject();

        } else {
            newProject = tmpProject;

        }
        
        // edit Date
        System.out.println("Enter the new Due Date, or enter no to keep it  :");

        tmpDate = readText();

        if (tmpDate.equals("no")) {

            newDate = contr.getTasks().get(index).getDueDate();

        } else {
            newDate = stringToDate(tmpDate);

        }

       

        contr.updateTask(index, newTitle, newDate, newProject);
        
        System.out.println("Task Updated Successfully");
        showUpdateTaskMenu();

        
    }

    private void setAsDone() {
        int index = getWantedTaskIndex();
        contr.getTasks().get(index).setIsDone(true);
        System.out.println("Great job !!");
        showUpdateTaskMenu();
    }

    private void removeTask() {
        int index = getWantedTaskIndex();
        contr.getTasks().remove(index);
        System.out.println("Task Removed !");
        showUpdateTaskMenu();
    }

    private int getWantedTaskIndex() {

        printToDoList(contr.getTasks());

        System.out.println("Enter the number of the task you want to edit : ");

        int index = getUserInput();

        if (index< contr.getTasks().size()) {
            return index;
        } else {
            System.out.println("Not a valid index !! ");
            return getWantedTaskIndex();

        }
    }

    private void showByDate() {

        System.out.println("*********    Date Sorted  *************");
        printToDoList(contr.sortByDueDate());
        System.out.println("***************************************");
        showTaskMenu();
     

    }

    private void showByProject() {
        System.out.println("*********    Project Sorted  **********");
        printToDoList(contr.sortByProject());
        System.out.println("***************************************");
       showTaskMenu();

    }

    private void showSearchMenu() {
        System.out.println("Enter Project Name : \n");
        String searchedProject= readText();
        ArrayList searchTask=contr.searchByProject(searchedProject);
        printToDoList(searchTask);
         printMenu();
        
              
    }

}
