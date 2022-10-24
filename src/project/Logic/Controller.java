package project.Logic;

import project.GUI.Main;

import javax.swing.*;
/**
 * class that manage panels
 * @author Sachkova E. D.
 */
public class Controller {
    public Controller(){};

    public void changePanel(JPanel panel){
        Main.setPanel(panel);
    }

    public void rollProgram(){
        Main.rollFrame();
    }
}
