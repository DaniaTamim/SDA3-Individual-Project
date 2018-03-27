/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StartUp;

import Controller.ToDoList;
import View.View;

/**
 *
 * @author tmp-sda-1171
 */
public class Main {
    private View viewer;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ToDoList contr=new ToDoList("Dania");
        View viewer = new View(contr);
        
        
        
        viewer.printWelcome();
        
        int res= viewer.getUserInput();
        
        viewer.parseUserInput(res);
        
       
        
        
        do {
            res=viewer.getUserInput();
            viewer.parseUserInput(res);

            //System.out.println(res);

        }
        while (res != 4);

    }
    
}
