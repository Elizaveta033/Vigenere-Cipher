package project.GUI;

import project.Entity.MyFont;
import project.Logic.Controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * create window with information
 * about author
 *
 * @author Sachkova E. D.
 */
public class AboutAuthorGUI extends JPanel {
    private JButton jbtnBack;
    private ImageIcon imageIconPhoto;
    public AboutAuthorGUI(){
        MyFont myFont = new MyFont();

        setLayout(new GridLayout(1, 3, 1, 10));

        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(3, 1, 1, 10));

        imageIconPhoto = new ImageIcon(getClass().getResource("resources/myPhoto2.jpg"));

        JTextArea aboutAuthor = new JTextArea("Автор:\n" +
                "студент группы 10702319\n" +
                "Сачкова Елизавета Дмитриевна\n" +
                "email:\nsachkova-elizaveta@mail.ru");
        aboutAuthor.setEditable(false);
        aboutAuthor.setLineWrap(true);
        aboutAuthor.setWrapStyleWord(true);
        aboutAuthor.setOpaque(false);
        aboutAuthor.setFont(myFont.getFont());

        JScrollPane jScrollPane=new JScrollPane(aboutAuthor);
        jScrollPane.setBorder(null);
        jScrollPane.setBackground(Color.GRAY);
        jScrollPane.getViewport().setOpaque(false);
        jScrollPane.setOpaque(false);

        jbtnBack = new JButton("Назад");
        jbtnBack.addActionListener(new Listener());
        jbtnBack.setFocusable(false);
        jbtnBack.setFont(myFont.getFont());

        panel.add(new JLabel(imageIconPhoto));
        panel.add(jScrollPane);
        panel.add(jbtnBack);

        add(new JLabel());
        add(panel);
        add(new JLabel());
    }
    class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jbtnBack) {
                Controller controller=new Controller();
                controller.changePanel(new AppGUI());
            }
        }
    }
}
