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

    public void updateTask(Task task) {

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

    // Print arraylist
/*    public void printToDoList(ArrayList<Task> tasks) {
        tasks.forEach((task) -> {
            System.out.println(task.toString());
        }); 
    }
*/
    public int numOfDoneTask() {

        int filteredByDoneTasks = 0;

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).isIsDone() == true) {
                filteredByDoneTasks++;
            }
        }

//        tasks.stream().filter((task) -> (task.isIsDone()==true)).sum();
//        });
        return filteredByDoneTasks;
    }

    public int numOfNotDoneTask() {

        return tasks.size() - numOfDoneTask();

    }

//    public void sortTasksByDueDate() {
//        Collections.sort(tasks, new Comparator<Task>() {
//
//            public String compare(Task t1, Task t2) {
//                return String.valueOf(t1.getProject(),t2.getProject());
//                
//            }
//
//        });

//    ArrayList<Task> sortedByDueDate = new ArrayList<>();
//    
//    for (int i =0; i< tasks.size();i++)
//    {   
//        
//    }
//
//    return sortedByDueDate.sort(c);
//    }
    /*public ArrayList searchTaskList_byProject(String project, ArrayList<Task> tasks) {

        ArrayList<Task> filteredByProjectTasks = new ArrayList<Task>();

        for (Task task : tasks) {
            if (task.getProject().equals("project")) {
                filteredByProjectTasks.add(task);
            }

        }
        return filteredByProjectTasks;
    }*/

 /*public ArrayList searchTaskList_byDueDate(Date dueDate, ArrayList<Task> tasks) {

        ArrayList<Task> filteredByDueDateTasks = new ArrayList<Task>();

        for (Task task : tasks) {
            if (task.getDueDate() == dueDate) {
                filteredByDueDateTasks.add(task);
            }

        }
        return filteredByDueDateTasks;
    }*/

    public ArrayList<Task> sortByDueDate() {
        //tasks.get(i).compare();
        return this.tasks;
    }

    public ArrayList<Task> sortByProject() {
     //tasks.get(i).compare();
        return this.tasks;
    }
}
