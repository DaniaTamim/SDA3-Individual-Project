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
 * @author Dania Tamim
 */
public class View {

    private static String menuType = "MainMenu";
    private ToDoList contr;

    public View(ToDoList contr) {
        this.contr = contr;
    }

    /**
     * print a welcome message on the start
     */
    public void printWelcome() {

        System.out.println(">> Welcome to ToDoly \n"
                + ">> You have   " + contr.numOfNotDoneTask() + "  tasks todo and   " + contr.numOfDoneTask() + "  tasks are done! \n ");

    }

    /**
     * printing a list of options to the user to deal with the program
     */
    public void printMenu() {

        System.out.println(">> Pick an option: \n"
                + ">> (1) Show Task List (Sorted by date or project) \n"
                + ">> (2) Add New Task \n"
                + ">> (3) Edit Task (update, mark as done, remove) \n"
                + ">> (4) Search By Project Name \n"
                + ">> (5) Save and Quit  \n"
                + ">> \n "
                + ">> Enter your choice : \n");
        parseUserInput(getUserInput());

    }

    /**
     * read the user input as an integer
     *
     * @return the number which the user enter it
     */
    public int getUserInput() {

        int userInput = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            userInput = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Enter a number please !");
        }

        return userInput;
    }

    /**
     * Translate the user input to the corresponding menu and deal with the
     * input if it is in the main menu or in sub menu
     *
     * @param input as an integer
     */
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
                        menuType = "MainMenu";
                        printMenu();

                        break;
                    }
                    default: {
                        menuType = "EditMenu";
                        System.out.println("Edit Menu : : Enter a valid number from the list please !");
                        break;

                    }
                }

            default:
                menuType = "MainMenu";
                System.out.println("upper switch :: Enter a valid number from the list please !");
                break;
        }

    }

    /**
     * print the ArrayList of Task which pass to it
     *
     * @param tasks as ArrayList
     */
    public void printToDoList(ArrayList<Task> tasks) {

        for (int i = 0; i < tasks.size(); i++) {

            System.out.println("(" + i + ")" + tasks.get(i).toString());
        }

        System.out.println();

    }

    /**
     * printing the menu to Add new task,take the information from the user and
     * pass it to the controller to create it
     */
    private void showAddTaskMenu() {

        System.out.println(" \n  >> (2) Add New Task \n ");

        System.out.println("Enter Title :\n ");
        String title = readText();

        System.out.println("Enter Project :\n ");
        String project = readText();

        System.out.println("Enter Due Date (With the Format : dd-MM-yyyy) :\n ");

        String tmpDate = readText();
        Date dueDate = stringToDate(tmpDate);
        while (dueDate == null) {

            dueDate = stringToDate(readText());
        }

        Task newtask = new Task(title, dueDate, project);

        contr.addTask(newtask);

        System.out.println("Task Added \n ");

        printMenu();

    }

    /**
     * Save the tasks to the file throw the controller and close the program
     */
    private void showExitMenu() {
        contr.saveToDoList();
        System.out.println(">> \n "
                + ">> Good Bye .. Have A Nice Day "
                + " Saving . . . and Exit  \n "
                + ">> \n ");
        System.exit(0);

    }

    /**
     * read the user in put as text
     *
     * @return String of the input
     */
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

    /**
     * Convert the text which the user write to a date type using the format we
     * provide to it
     *
     * @param dateString
     * @return Date data type of the input
     */
    public Date stringToDate(String dateString) {
        //String string = "January 2, 2010";''
        Date date = new Date();
        try {
            DateFormat form = new SimpleDateFormat("dd-MM-yyyy");
            date = form.parse(dateString);
        } catch (ParseException ex) {
            date = null;
            System.out.println("Enter a valid format please !!");

        }

        return date;

    }

    /**
     * printing show list menu to the user
     */
    private void showTaskMenu() {

        System.out.println(" \n "
                + ">> (1) Show Task List by date  \n "
                + ">> (2) Show Task List by project \n "
                + ">> (0) To Go Back \n "
                + ">> \n "
                + ">>  Enter your choice : \n");
        parseUserInput(getUserInput());

    }

    /**
     * printing the Edit task menu to the user
     */
    private void showUpdateTaskMenu() {

        System.out.println("\n"
                + ">> Edit Task :  \n"
                + ">> (1) Update Task  \n"
                + ">> (2) Mark Task as Done  \n"
                + ">> (3) Remove Task) \n"
                + ">> (0) To Go Back \n"
                + ">> \n "
                + ">>  Enter your choice : \n");
        parseUserInput(getUserInput());
    }

    /**
     * Allow the user to update a specific task
     */
    private void UpdateTasks() {

        String tmpTitle, newTitle, tmpProject, newProject, tmpDate;
        Date newDate;

        int index = getWantedTaskIndex();
        if (index != -1) {
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
            System.out.println("Enter the new Due Date (With the Format : dd-MM-yyyy), or enter no to keep it  :");

            tmpDate = readText();

            if (tmpDate.equals("no")) {

                newDate = contr.getTasks().get(index).getDueDate();

            } else {
                newDate = stringToDate(tmpDate);
                while (newDate == null) {
                    newDate = stringToDate(readText());
                }

            }

            contr.updateTask(index, newTitle, newDate, newProject);

            System.out.println("Task Updated Successfully");
            showUpdateTaskMenu();
        } else {
            showUpdateTaskMenu();
        }
    }

    /**
     * mark the specific task as done
     */
    private void setAsDone() {
        int index = getWantedTaskIndex();
        contr.getTasks().get(index).setIsDone(true);
        System.out.println("Great job !!");
        showUpdateTaskMenu();
    }

    /**
     * Remove task from the ArrayList of tasks
     */
    private void removeTask() {
        int index = getWantedTaskIndex();
        if (index != -1) {

            contr.getTasks().remove(index);
            System.out.println("Task Removed !");
            showUpdateTaskMenu();
        }
    }

    /**
     * Print the ArrayList of tasks and get the index of the task we choose and
     * check if it is a valid index
     *
     * @return index as integer
     */
    private int getWantedTaskIndex() {
        if (contr.getTasks().isEmpty()) {
            System.out.println("There is no tasks to edit .. ");
            return -1;
        } else {
            printToDoList(contr.getTasks());

            System.out.println("Enter the number of the task you want to edit : ");

            int index = getUserInput();

            if (index < contr.getTasks().size()) {
                return index;
            } else {
                System.out.println("Not a valid index !! ");
                return getWantedTaskIndex();

            }
        }
    }

    /**
     * print the ArrayList of tasks sorted by Due date
     */
    private void showByDate() {

        System.out.println("******************************    Date Sorted  ***********************************");
        printToDoList(contr.sortByDueDate());
        System.out.println("**********************************************************************************");
        showTaskMenu();

    }

    /**
     * print the ArrayList of tasks sorted by Project
     */
    private void showByProject() {
        System.out.println("****************************    Project Sorted  *********************************");
        printToDoList(contr.sortByProject());
        System.out.println("*********************************************************************************");
        showTaskMenu();

    }

    /**
     * Searching the ArrayList of tasks for the specified project name and print
     * the filtered list to the user
     */
    private void showSearchMenu() {
        System.out.println("Enter Project Name : \n");
        String searchedProject = readText();
        ArrayList searchTask = contr.searchByProject(searchedProject);
        if (searchTask.isEmpty()) {
            System.out.println("No Tasks Found !! ");
        } else {
            printToDoList(searchTask);

        }
        printMenu();

    }

}
