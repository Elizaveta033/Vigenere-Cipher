package project.Entity;

import project.GUI.SettingGUI;
import java.awt.Font;
/**
 * font class
 *
 * @author Sachkova E. D.
 */
public class MyFont {
    private int size;
    private Font font;
    public MyFont(){
        SettingGUI sliderSize = new SettingGUI();
        size= sliderSize.getFontSize();
        font=new Font("Verdana", Font.PLAIN,size);
    }
    public Font getFont(){
        return font;
    }
}
