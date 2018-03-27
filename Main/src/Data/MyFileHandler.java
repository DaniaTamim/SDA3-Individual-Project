/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Task;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author tmp-sda-1171
 */
public class MyFileHandler {
    private String fileName;

	public void createFile(String fileName) {

	}

	public boolean isFileExist() {
		return false;
	}

	public ArrayList<Task> readToDoList() {
		return null;
	}
 /**
     *
     * @param tasks
     */
	public void saveToDoList(ArrayList<Task> tasks) {

	}
        
        public MyFileHandler() {


    }

    public void readFile(String fileName) {
        File file = new File(fileName);

    }

    public void writeTaskToFile(String fileName, Task task) {
        File file = new File(fileName);
        PrintWriter out;
        try {
            out = new PrintWriter(file);
            out.println(task.toString());
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }

    }

    public void saveFile() {

    }

   
    
}
