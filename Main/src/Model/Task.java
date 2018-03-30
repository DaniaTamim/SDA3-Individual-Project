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
 * @author tmp-sda-1171
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
    public Task addTask(String title, Date dutDate, String project) {
        return new Task(title, dueDate, project);
    }

    public Task updateTask(String title, Date dutDate, boolean isdone, String project) {

        this.Title = title;
        this.dueDate = dutDate;
        this.isDone = isdone;
        this.project = project;

        return this;
    }

    public void markAsDone(Task task) {
        this.isDone = true;

    }

    @Override
    public String toString() {

//         SimpleDateFormat form = new SimpleDateFormat("MM-dd-yyyy");
//        Date date = form.parse("11-12-1111");
//        Date date2 = new Date();
//        
//        
//        System.out.println(date);
//        System.out.println("2: " + form.format(date));
//        
        return   " *   " + getTitle() + "   "
                +"  project is : " + getProject() + "   " 
                +" due date is : " + getDueDate() +  "   "
                +"       Task is done  " + isIsDone();

    }

    /*
    @Override
    public int compareTo(Object task) {
        
        //if (this.getProject().compareTo(task.getProject()))
           // return 
           
           Task t=(Task) task;
        if (task == null )
        {
            return -500;
        }
        
        if (this.getProject().equals(t.getProject()))
            {
                return 0;
            }
        
        
        if (!this.getProject().contentEquals(t.getProject()))
            {
                    return this.compareTo(t.getProject());
           
            }
        
        
        
        }
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
            //compare by 
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
