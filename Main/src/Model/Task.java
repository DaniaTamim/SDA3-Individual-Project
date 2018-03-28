/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author tmp-sda-1171
 */
public class Task  implements Comparable,Serializable {

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
        this.isDone=true;

    }

    @Override
    public String toString() {
        return " * " + getTitle() + "   The due date is : " + getDueDate() + "    The project is : " + getProject() + "       Task is done" + isIsDone();

    }

   

    @Override
    public int compareTo(Object o) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
