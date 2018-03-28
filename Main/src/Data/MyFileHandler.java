/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Task;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;

/**
 *
 * @author tmp-sda-1171
 */
public class MyFileHandler {

    //private String fileName;
    private File file;

    public MyFileHandler(String filename) throws IOException {
        file = new File(filename);
        file.createNewFile();

    }

 

    public ArrayList<Task> readToDoList() {

        ArrayList<Task> readedtasks = new ArrayList<>();
        try {
            FileInputStream fileStream = new FileInputStream(file);
            ObjectInputStream objStream = new ObjectInputStream(fileStream);

            /*if(objStream.readObject() == null)
                readedtasks = new ArrayList<Task>();
            else 
            // Read objects*/
            readedtasks = (ArrayList<Task>) objStream.readObject();
        } catch (IOException | ClassNotFoundException ioe) {
            System.out.println("Data.MyFileHandler.readToDoList()");
        }

        return readedtasks;
    }

    /**
     *
     * @param tasks
     */
    public void saveToDoList(ArrayList<Task> tasks) {

        try {
            FileOutputStream fileStream = new FileOutputStream(file);
            ObjectOutputStream objStream = new ObjectOutputStream(fileStream);

            objStream.writeObject(tasks);
        } catch (Exception e) {
            System.out.println("Data.MyFileHandler.readToDoList()");
        }

    }

}
/*  File file = new File(fileName);
            PrintWriter out;
            try {
            out = new PrintWriter(file);
            tasks.forEach((task) -> {
            out.println(task.toString());
            });
            out.close();
            } catch (IOException e) {
            System.out.println(e.getMessage());
            }*/
