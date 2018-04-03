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
import java.util.Collections;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dania Tamim
 */
public class ToDoList {

    private String name;

    private ArrayList<Task> tasks;

    private MyFileHandler myFileHandler;

    //******************************'
    public ToDoList(String name) {

        this.myFileHandler = new MyFileHandler("ToDoListFile.txt");

        this.name = name;
        tasks = myFileHandler.readToDoList();

    }

    public ToDoList(String name, ArrayList<Task> tasks) {

        this.myFileHandler = new MyFileHandler("ToDoListFile.txt");

        this.name = name;
        this.tasks = tasks;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    //*******************************
    public void addTask(Task task) {
        tasks.add(task);

    }

    /**
     *
     * @param index of the Task to update
     * @param newTitle of the task to update
     * @param newDate of the task to update
     * @param newProject of the task to update
     */
    public void updateTask(int index, String newTitle, Date newDate, String newProject) {
        if (!tasks.isEmpty()) {
            if (index < tasks.size()) {
                tasks.get(index).setDueDate(newDate);
                tasks.get(index).setProject(newProject);
                tasks.get(index).setTitle(newTitle);
            }
        }
    }

    /**
     *
     * @param task to set it as done
     */
    public void setTaskDone(Task task) {
        if (!tasks.isEmpty()) {
            task.setIsDone(true);
        } else {
        }
    }

    /**
     *
     * @param task to remove from the ArrayList of Tasks
     */
    public void removeTask(Task task) {
        if (!tasks.isEmpty()) {
            tasks.remove(task);
        }
    }

    /**
     *
     * @param project to get all the tasks belong to it
     * @return ArrayList of Tasks filtered by the project
     */
    public ArrayList<Task> searchByProject(String project) {
        if (!tasks.isEmpty()) {

            ArrayList<Task> filteredByProjectTasks = new ArrayList<>();

            tasks.stream().filter((task) -> (task.getProject().equals(project))).forEachOrdered((task) -> {
                filteredByProjectTasks.add(task);
            });
            return filteredByProjectTasks;
        } else {
            return null;
        }
    }

    /**
     *
     * @param dueDate to get all the tasks with the Due date
     * @return ArrayList of Tasks filtered by the due date
     */
    public ArrayList<Task> searchByDueDate(Date dueDate) {
        if (!tasks.isEmpty()) {

            ArrayList<Task> filteredByDueDateTasks = new ArrayList<>();

            tasks.stream().filter((task) -> (task.getDueDate() == dueDate)).forEachOrdered((task) -> {
                filteredByDueDateTasks.add(task);
            });
            return filteredByDueDateTasks;
        } else {
            return null;
        }
    }

    /**
     * Save the ArrayList of Tasks to the file throw the controller
     */
    public void saveToDoList() {
        if (tasks != null) {

            myFileHandler.saveToDoList(tasks);

        }
        else 
            myFileHandler.saveToDoList(null);

    }

    /**
     * read the file to get Tasks
     *
     * @return ArrayList of Tasks
     */
    public ArrayList<Task> readToDoList() {
        return myFileHandler.readToDoList();
    }

    /**
     * Get the number of the Done Tasks from the ArrayList of Tasks
     *
     * @return integer as the number of Done Tasks
     */
    public int numOfDoneTask() {
        if (!tasks.isEmpty()) {
            int filteredByDoneTasks = 0;

            for (int i = 0; i < tasks.size(); i++) {
                if (tasks.get(i).isIsDone() == true) {
                    filteredByDoneTasks++;
                }
            }

            return filteredByDoneTasks;
        } else {
            return 0;
        }
    }

    /**
     * Get the number of UnDone Tasks
     *
     * @return integer as the number of the undone tasks
     */
    public int numOfNotDoneTask() {
        if (!tasks.isEmpty()) {
            return tasks.size() - numOfDoneTask();
        } else {
            return 0;
        }

    }

    /**
     * Sort the ArrayList of tasks by the DueDate
     *
     * @param list of Tasks to sort it
     * @return the same list Sorted by due date
     */
    public ArrayList<Task> sortByDueDate(ArrayList<Task> list) {
        //tasks.get(i).compare();
        Collections.sort(list);
        return list;
    }

    /**
     * Sort the ArrayList of tasks by the DueDate
     *
     * @return the same list Sorted by due date
     */
    public ArrayList<Task> sortByDueDate() {
        //tasks.get(i).compare();
        return sortByDueDate(tasks);
        /*ArrayList<Task> arr = new ArrayList<>();
        Collections.sort(tasks);
        return tasks;*/
    }

    /**
     * Sort the ArrayList of tasks by the project name
     *
     * @param list of Tasks to sort it
     * @return the same list Sorted by project
     */
    public ArrayList<Task> sortByProject(ArrayList<Task> list) {
        //tasks.get(i).compare();
        Collections.sort(list);
        return list;
    }

    /**
     * Sort the ArrayList of tasks by the project name
     *
     * @return the same list Sorted by project
     */
    public ArrayList<Task> sortByProject() {
        //tasks.get(i).compare();
        return sortByProject(tasks);
    }
}
