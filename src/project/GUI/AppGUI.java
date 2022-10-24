package project.GUI;

import project.Entity.MyFont;
import project.Entity.VigenereCoder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * create main window
 *
 * @author Sachkova E. D.
 */
public class AppGUI extends JPanel {
    private JButton jbtnCoder;
    private JButton jbtnEncoder;
    private JButton jbtnSwap;
    static JTextArea specialWord;
    static JTextArea inputText;
    static JTextArea rezult;
    static JComboBox languageJComboBox;
    final String[] ITEM = {
            "Русский язык",
            "Английский язык"
    };

    public AppGUI(){
        MyFont myFont = new MyFont();
        setLayout(new GridLayout(1, 3, 1, 10));

        JLabel jlblInputText=new JLabel("Введите текст:");
        jlblInputText.setFont(myFont.getFont());

        inputText = new  JTextArea("",9,10);
        inputText.setLineWrap(true);
        inputText.setWrapStyleWord(true);
        inputText.setFont(myFont.getFont());

        JLabel jlblSpecialWord=new JLabel("Введите секретное слово:");
        jlblSpecialWord.setFont(myFont.getFont());

        //создание jbutton
        jbtnCoder = new JButton("Зашифровать");
        jbtnCoder.addActionListener(new Listener());
        jbtnCoder.setFocusable(false);
        jbtnCoder.setFont(myFont.getFont());

        jbtnEncoder = new JButton("Дешифровать");
        jbtnEncoder.addActionListener(new Listener());
        jbtnEncoder.setFocusable(false);
        jbtnEncoder.setFont(myFont.getFont());

        jbtnSwap = new JButton("<-");
        jbtnSwap.addActionListener(new Listener());
        jbtnSwap.setFocusable(false);
        jbtnSwap.setFont(myFont.getFont());

        specialWord = new JTextArea();
        specialWord.setLineWrap(true);
        specialWord.setWrapStyleWord(true);
        specialWord.setFont(myFont.getFont());

        JLabel jlblRezult=new JLabel("Здесь вы увидите результат:");
        jlblRezult.setFont(myFont.getFont());

        rezult = new JTextArea("");
        rezult.setEditable(false);
        rezult.setLineWrap(true);
        rezult.setWrapStyleWord(true);
        rezult.setOpaque(true);
        rezult.setBackground(Color.WHITE);
        rezult.setFont(myFont.getFont());

        languageJComboBox = new JComboBox(ITEM);
        languageJComboBox.setFont(myFont.getFont());

        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new GridLayout(11, 1, 1, 10));
        middlePanel.add(new JLabel());
        middlePanel.add(languageJComboBox);
        middlePanel.add(jlblSpecialWord);
        middlePanel.add(new JScrollPane(specialWord));
        middlePanel.add(new JLabel());
        middlePanel.add(jbtnCoder);
        middlePanel.add(jbtnEncoder);
        middlePanel.add(jbtnSwap);
        middlePanel.add(new JLabel());
        middlePanel.add(new JLabel());
        middlePanel.add(new JLabel());

        JPanel leftPanel= new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.add(BorderLayout.NORTH,jlblInputText);
        leftPanel.add(BorderLayout.CENTER,new JScrollPane(inputText));

        JPanel rightPanel= new JPanel();

        rightPanel.setLayout(new BorderLayout());
        rightPanel.add(BorderLayout.NORTH,jlblRezult);
        rightPanel.add(BorderLayout.CENTER,new JScrollPane(rezult));

        add(leftPanel);
        add(middlePanel);
        add(rightPanel);
    }
//determining the selected language
    public static int getLanguage() {
        return languageJComboBox.getSelectedIndex();
    }

    class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jbtnCoder) {
                VigenereCoder coder = new VigenereCoder();
                rezult.setText(coder.vigenereCoder(specialWord.getText(),inputText.getText()));
            } else if (e.getSource() == jbtnEncoder) {
                VigenereCoder encoder = new VigenereCoder();
                rezult.setText(encoder.vigenereDecoder(specialWord.getText(),inputText.getText()));
            }
            else if (e.getSource() == jbtnSwap){
                inputText.setText(rezult.getText());
            }
        }
    }
}
