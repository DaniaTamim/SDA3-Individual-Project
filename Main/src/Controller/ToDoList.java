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

/**
 *
 * @author tmp-sda-1171
 */
public class ToDoList {

    private String name;

    private ArrayList<Task> tasks;

    private MyFileHandler myFileHandler;

    //******************************'
    public ToDoList(String name) throws IOException {
        this.myFileHandler = new MyFileHandler("ToDoListFile.txt");

        this.name = name;
        tasks = myFileHandler.readToDoList();
    }

    public ToDoList(String name, ArrayList<Task> tasks) throws IOException {
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

    public void updateTask(int index, String newTitle, Date newDate, String newProject) {
        if (index < tasks.size()) 
        {
            tasks.get(index).setDueDate(newDate);
            tasks.get(index).setProject(newProject);
            tasks.get(index).setTitle(newTitle);
        }

    }

    public void setTaskDone(Task task) {
        task.setIsDone(true);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public ArrayList<Task> searchByProject(String project) {

        ArrayList<Task> filteredByProjectTasks = new ArrayList<>();

        tasks.stream().filter((task) -> (task.getProject().equals(project))).forEachOrdered((task) -> {
            filteredByProjectTasks.add(task);
        });
        return filteredByProjectTasks;
    }

    public ArrayList<Task> searchByDueDate(Date dueDate) {

        ArrayList<Task> filteredByDueDateTasks = new ArrayList<>();

        tasks.stream().filter((task) -> (task.getDueDate() == dueDate)).forEachOrdered((task) -> {
            filteredByDueDateTasks.add(task);
        });
        return filteredByDueDateTasks;
    }

    public void saveToDoList() {

        myFileHandler.saveToDoList(tasks);

    }

    public ArrayList<Task> readToDoList() {
        return myFileHandler.readToDoList();
    }

    public int numOfDoneTask() {

        int filteredByDoneTasks = 0;

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).isIsDone() == true) {
                filteredByDoneTasks++;
            }
        }

        return filteredByDoneTasks;
    }

    public int numOfNotDoneTask() {

        return tasks.size() - numOfDoneTask();

    }

    public ArrayList<Task> sortByDueDate(ArrayList<Task> list) {
        //tasks.get(i).compare();
        Collections.sort(list);
        return list;
    }

    public ArrayList<Task> sortByDueDate() {
        //tasks.get(i).compare();
        return sortByDueDate(tasks);
        /*ArrayList<Task> arr = new ArrayList<>();
        Collections.sort(tasks);
        return tasks;*/
    }

    public ArrayList<Task> sortByProject() {
        //tasks.get(i).compare();
        return this.tasks;
    }
}
