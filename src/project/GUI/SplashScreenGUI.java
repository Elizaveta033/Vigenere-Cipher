package project.GUI;

import project.Logic.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * create Splash Screen window
 * @author Sachkova E. D.
 */
public class SplashScreenGUI extends JPanel {
    private JLabel bntuJLabel;
    private JLabel fitrJLabel;
    private JLabel departmentJLabel;
    private JLabel courseWorkJLabel;
    private JLabel javaProgramingJLabel;
    private JLabel courseSubjectJLabel;
    private JLabel imgJLabel;
    private JLabel studentJLabel;
    private JLabel studentNameJLabel;
    private JLabel teacherJLabel;
    private JLabel teacherNameJLabel;
    private JLabel minskJLabel;
    private JButton nextJButton;
    private JButton exitJButton;
    private ImageIcon imageImageIcon;

    /**
     * Constructor for creating an object
     */
    public SplashScreenGUI(){
        setLayout(null);

        Font font=new Font("Verdana",Font.PLAIN,14);

        bntuJLabel =new JLabel("Белорусский национальный технический университет");
        bntuJLabel.setFont(font);
        add(bntuJLabel).setBounds(200,10,600,20);

        fitrJLabel =new JLabel("Факультет информацонных технологий и робототехники");
        fitrJLabel.setFont(font);
        add(fitrJLabel).setBounds(190,50,600,20);

        departmentJLabel =new JLabel("Кафедра программного обеспечения информационных систем и технологий");
        departmentJLabel.setFont(font);
        add(departmentJLabel).setBounds(130,70,600,20);

        font=new Font("Verdana",Font.BOLD,16);
        courseWorkJLabel =new JLabel("Курсовая работа");
        courseWorkJLabel.setFont(font);
        add(courseWorkJLabel).setBounds(320,160,400,20);

        font=new Font("Verdana",Font.PLAIN,14);
        javaProgramingJLabel =new JLabel("По дисциплине «Программировние на языке Java»");
        javaProgramingJLabel.setFont(font);
        add(javaProgramingJLabel).setBounds(240,180,400,20);

        font=new Font("Verdana",Font.BOLD,18);
        courseSubjectJLabel =new JLabel("Шифр Виженера кодирования данных (кириллица)");
        courseSubjectJLabel.setFont(font);
        add(courseSubjectJLabel).setBounds(70,240,700,20);

        font=new Font("Verdana",Font.PLAIN,14);
        studentJLabel =new JLabel("Выполнил: Студент группы 10702319");
        studentJLabel.setFont(font);
        add(studentJLabel).setBounds(450,300,400,20);

        studentNameJLabel =new JLabel("Сачкова Елизавета Дмитриевна");
        studentNameJLabel.setFont(font);
        add(studentNameJLabel).setBounds(450,320,400,20);

        teacherJLabel =new JLabel("Преподаватель: к.ф.-м.н.доц.");
        teacherJLabel.setFont(font);
        add(teacherJLabel).setBounds(450,420,400,20);

        teacherNameJLabel =new JLabel("Сидорик Валерий Владимирович");
        teacherNameJLabel.setFont(font);
        add(teacherNameJLabel).setBounds(450,440,400,20);

        minskJLabel =new JLabel("Минск, 2022");
        minskJLabel.setFont(font);
        add(minskJLabel).setBounds(330,535,200,20);

        imageImageIcon = new ImageIcon(getClass().getResource("resources/VigenerePicture.jpg"));
        imgJLabel = new JLabel(imageImageIcon);
        add(imgJLabel).setBounds(10,265,350,300);

        nextJButton = new JButton("Далее");
        nextJButton.setFocusable(false);

        nextJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller controller = new Controller();
                controller.changePanel(new AppGUI());
                Main.mainWindow= new SettingGUI();
            }
        });

        nextJButton.setFont(font);
        nextJButton.setSize(200,30);
        add(nextJButton).setBounds(85,570,200,30);

        exitJButton = new JButton("Выход");
        exitJButton.setFocusable(false);

        exitJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        exitJButton.setFont(font);
        exitJButton.setSize(200,30);
        add(exitJButton).setBounds(485,570,200,30);

    }
}