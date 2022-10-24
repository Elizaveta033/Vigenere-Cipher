package project.GUI;

import project.Logic.Controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * create setting window
 *
 * @author Sachkova E. D.
 */
public class SettingGUI extends JPanel {
    private JSlider slider;
    private JButton backToMenu;
    private JButton apply;
    static int value=14;

    public SettingGUI(){
        Font font = new Font("Verdana", Font.PLAIN,value);

        setLayout(new GridLayout(5, 1, 1, 10));

        JPanel panel=new JPanel();
        panel.setLayout(new BorderLayout());
        slider = new JSlider(6, 40, value);

        slider.setMajorTickSpacing(2);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        slider.setFont(font);

        JLabel fontSize = new JLabel(" Величина шрифта");
        fontSize.setFont(font);

        JPanel btnJPanel=new JPanel();
        btnJPanel.setLayout(new GridLayout(1,2,1,1));

        apply = new JButton("Применить");
        apply.addActionListener(new ApplyListener());
        apply.setFocusable(false);
        apply.setFont(font);

        backToMenu = new JButton("Назад");
        backToMenu.addActionListener(new BackListener());
        backToMenu.setFocusable(false);
        backToMenu.setFont(font);

        panel.add(slider);
        btnJPanel.add(apply);
        btnJPanel.add(backToMenu);

        add(fontSize);
        add(panel);
        add(new JLabel(""));
        add(new JLabel(""));
        add(btnJPanel);
    }
    public int getFontSize(){
        return value;
    }
    class ApplyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == apply) {
                value=slider.getValue();
                Controller controller=new Controller();
                controller.changePanel(new SettingGUI());
            }
        }
    }

    class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == backToMenu) {
                Controller controller=new Controller();
                controller.changePanel(new AppGUI());
            }
        }
    }
}
