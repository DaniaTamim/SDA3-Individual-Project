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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dania Tamim
 */
public class MyFileHandler {

    //private String fileName;
    private File file;

    public MyFileHandler(String filename)  {
        file = new File(filename);
        try {
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(MyFileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * read the tasks from the file
     *
     * @return ArrayList of Tasks
     */
    public ArrayList<Task> readToDoList() {

        ArrayList<Task> readedtasks = new ArrayList<>();
        try {
            FileInputStream fileStream = new FileInputStream(file);
            ObjectInputStream objStream = new ObjectInputStream(fileStream);

            readedtasks = (ArrayList<Task>) objStream.readObject();

            fileStream.close();
            objStream.close();
        } catch (IOException | ClassNotFoundException ioe) {
            System.out.println("Creating New File . . . ");
        }

        return readedtasks;
    }

    /**
     * Save the tasks to the file
     *
     * @param tasks as an ArrayList
     */
    public void saveToDoList(ArrayList<Task> tasks) {
        if (tasks != null) {
            if (!tasks.isEmpty()) {
                FileOutputStream fileStream;
                ObjectOutputStream objStream;
                try {
                    fileStream = new FileOutputStream(file);
                    objStream = new ObjectOutputStream(fileStream);

                    objStream.writeObject(tasks);
                    fileStream.close();
                    objStream.close();
                } catch (Exception e) {
                    System.out.println("Data.MyFileHandler.readToDoList()");
                }

            } else {

                file.delete();

            }

        } else {

            FileOutputStream fileStream;
            ObjectOutputStream objStream;
            try {
                file.delete();
                fileStream = new FileOutputStream(file);
                objStream = new ObjectOutputStream(fileStream);

                objStream.writeObject(null);
                fileStream.close();
                objStream.close();
            } catch (Exception e) {
                System.out.println("Data.MyFileHandler.readToDoList()");
            }
        }

    }

}
