package project.GUI;

import project.Entity.MyFont;
import project.Logic.Controller;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * create JFrame and JMenuFrame
 *
 * @author Sachkova E. D.
 */
public class Main extends JFrame{
    static JFrame frame;
    public static SettingGUI mainWindow;

    public static void main(String[] args) {
        frame = new JFrame();
        frame.setTitle("Шифр Виженера");
        frame.setSize(800,650);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        SplashScreenGUI startPanel = new SplashScreenGUI();
        frame.add(startPanel);

        frame.setVisible(true);

        long start = System.currentTimeMillis();
        long end = start + 60*1000;

        while(true){
            if (System.currentTimeMillis()>end && mainWindow == null){
                System.exit(0);
            }
            if (mainWindow!=null) break;
        }
    }

    public static void setPanel(JPanel panel){
        frame.getContentPane().removeAll();
        frame.setResizable(true);
        frame.setJMenuBar(createJMenuBar());
        frame.add(panel);
        frame.repaint();
        frame.setVisible(true);
    }
/**method to minimize the window*/
    public static void rollFrame(){
        frame.setState(JFrame.ICONIFIED);
    }
/**method for creating JMenuBar*/
    public static JMenuBar createJMenuBar(){
        MyFont myFont = new MyFont();
        JMenuBar menuBar = new JMenuBar();

        JMenu file = new JMenu("Файл");
        file.setFont(myFont.getFont());

        JMenuItem setting = new JMenuItem("Настройки");
        setting.addActionListener(new SettingListener());
        setting.setFont(myFont.getFont());

        JMenuItem roll = new JMenuItem("Свернуть");
        roll.addActionListener(new RollListener());
        roll.setFont(myFont.getFont());

        JMenuItem exit = new JMenuItem("Выход");
        exit.addActionListener(new ExitListener());
        exit.setFont(myFont.getFont());

        file.add(setting);
        file.addSeparator();
        file.add(roll);
        file.add(exit);

        JMenu help = new JMenu("Справка");
        help.setFont(myFont.getFont());

        JMenuItem aboutVigenereCipher = new JMenuItem("О программе");
        aboutVigenereCipher.addActionListener(new AboutVigenereCipherListener());
        aboutVigenereCipher.setFont(myFont.getFont());

        JMenuItem aboutAuthor = new JMenuItem("Об авторе");
        aboutAuthor.addActionListener(new AboutAuthorListener());
        aboutAuthor.setFont(myFont.getFont());

        help.add(aboutVigenereCipher);
        help.add(aboutAuthor);

        menuBar.add(file);
        menuBar.add(help);
        return menuBar;
    }
    static class SettingListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller controller=new Controller();
            controller.changePanel(new SettingGUI());
        }
    }

    static class RollListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller controller=new Controller();
            controller.rollProgram();
        }
    }

    static class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    static class AboutVigenereCipherListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller controller=new Controller();
            controller.changePanel(new AboutVigenereCipherGUI());
        }
    }

    static class AboutAuthorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller controller=new Controller();
            controller.changePanel(new AboutAuthorGUI());
        }
    }
}
