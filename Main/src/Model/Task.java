/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Dania Tamim
 */
public class Task implements Comparable, Serializable {

    private String Title;

    private Date dueDate;

    private boolean isDone;

    private String project;
    

    public Task(String Title, Date dueDate, String project) {
        this.Title = Title;
        this.dueDate = dueDate;
        this.isDone = false;
        this.project = project;
    }

    // public Setters and Getters
    //*******************************
    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isIsDone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    //*******************************
    /**
     * Add New Task with the status undone by default
     * @param title
     * @param dutDate
     * @param project
     * @return new Task object
     */
    public Task addTask(String title, Date dutDate, String project) {
        return new Task(title, dueDate, project);
    }

    
    /**
     * Update the task with new values
     * @param title
     * @param dutDate
     * @param isdone
     * @param project
     * @return the Task with the updated values 
     */
    public Task updateTask(String title, Date dutDate, boolean isdone, String project) {

        this.Title = title;
        this.dueDate = dutDate;
        this.isDone = isdone;
        this.project = project;

        return this;
    }

  /**
   * override the tosString method to be able to print the Tasks 
   * and save it to the file 
   * @return String of the Tasks Object attributes
   */

    @Override
    public String toString() {

        SimpleDateFormat form = new SimpleDateFormat("MM-dd-yyyy");
        Date date = getDueDate();

        String status;
        if (isIsDone() == true) {
            status = "Task is Done ";
        } else {
            status = "Task is NOT Done ";
        }

//        
        return " *   " + getTitle() + "   "
                + "  project is : " + getProject() + "   "
                + " due date is : " + form.format(date) + "   "
                + status + "\n";

    }

//    @Override
//    public int compareTo(Object task) {
//
//        Task t = (Task) task;
//        if (task == null) {
//            return -500;
//        }
//
//        if (this.getProject().equals(t.getProject())) {
//            return this.getDueDate().compareTo(t.getDueDate());
//        } else {
//            return this.getProject().compareTo(t.getProject());
//        }
//
//    }
    
    
    /**
     * Compare two tasks objects with the due date 
     * and if it is equals compare them by the project name
     * @param task 
     * @return 0 if the two tasks are equal and 1 if the first is bigger or -1 if it is smaller
     */
    
    @Override
    public int compareTo(Object task) {

        //if (this.getProject().compareTo(task.getProject()))
        // return 
        Task t = (Task) task;
        if (task == null) {
            return -500;
        }

        if (this.getDueDate().equals(t.getDueDate())) {
            //compare by project 
            return this.getProject().compareTo(t.getProject());

        } else {

            return this.getDueDate().compareTo(t.getDueDate());

        }

    }

//    public static <T extends Comparable<T>> T compareTo(T task) {
//
//        //if (this.getProject().compareTo(task.getProject()))
//        // return 
//        T m = task;
//        if (m.compareTo(task) == 0) {
//              
//            return task;
//        
//        }
//        else if (m.compareTo(task)>0){
//        return m;
//        }
//        else {
//        return task;
//        }
//    }
}
