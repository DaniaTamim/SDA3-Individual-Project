/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StartUp;

import Controller.ToDoList;
import View.View;
import java.io.IOException;

/**
 *
 * @author tmp-sda-1171
 */
public class Main {

    //private View viewer;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        // TODO code application logic here
        
        ToDoList contr = new ToDoList("Dania");
        
        View viewer = new View(contr);

        viewer.printWelcome();
        viewer.printMenu();
        int res;
        do
        {  //viewer.printMenu();
            
            res = viewer.getUserInput();

            viewer.parseUserInput(res);

        } while(res!= 5);

    }

}
