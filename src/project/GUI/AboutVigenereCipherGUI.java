package project.GUI;

import project.Entity.MyFont;
import project.Logic.Controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * create window with information
 * about vigenere cipher
 *
 * @author Sachkova E. D.
 */
public class AboutVigenereCipherGUI extends JPanel {
    private ImageIcon imageIconSquare;
    private JButton jbtnBack;

    public AboutVigenereCipherGUI(){
        MyFont myFont = new MyFont();
        setLayout(new BorderLayout());

        imageIconSquare = new ImageIcon(getClass().getResource("resources/SquareTable.png"));

        JTextArea aboutVigenereCipher = new JTextArea("Шифр Виженера — метод полиалфавитного шифрования буквенного текста " +
                "с использованием ключевого слова.\n"+
                "Этот метод является простой формой многоалфавитной замены."+"\n" +
                " Шифр Виженера состоит из последовательности нескольких шифров Цезаря с различными значениями сдвига. "+
                "В шифре Цезаря каждая буква алфавита" +
                " сдвигается на несколько позиций, например при сдвиге +3, A стало бы D, B стало бы E и так далее.\n"+
                "В шифре Виженера " +
                "может использоваться таблица алфавитов, называемая tabula recta или квадрат (таблица) Виженера. " +
                "Применительно к латинскому алфавиту таблица Виженера составляется из строк по 26 символов," +
                " причём каждая следующая строка сдвигается на несколько позиций." +
                " Таким образом, в таблице получается 26 различных шифров Цезаря." +
                " На каждом этапе шифрования используются различные алфавиты, выбираемые" +
                " в зависимости от символа ключевого слова. " +
                "Например, предположим, что исходный текст имеет такой вид:\n" +
                "\n" +
                "ATTACKATDAWN\n\n" +
                "Человек, посылающий сообщение, записывает ключевое слово («LEMON») циклически до тех пор," +
                " пока его длина не будет соответствовать длине исходного текста:\n" +
                "\n" +
                "LEMONLEMONLE\n\n" +
                "Первый символ исходного текста («A») зашифрован последовательностью L, которая является первым символом ключа." +
                " Первый символ зашифрованного текста («L») находится на пересечении строки L и столбца A в таблице Виженера." +
                " Точно так же для второго символа исходного текста используется второй символ ключа;" +
                " то есть второй символ зашифрованного текста («X») получается на пересечении строки E и столбца T." +
                " Остальная часть исходного текста шифруется подобным способом.\n" +
                "\n" +
                "Исходный текст:       ATTACKATDAWN\n" +
                "Ключ:                 LEMONLEMONLE\n" +
                "Зашифрованный текст:  LXFOPVEFRNHR\n\n" +
                "Расшифровывание производится следующим образом: находим в таблице Виженера строку," +
                " соответствующую первому символу ключевого слова;" +
                " в данной строке находим первый символ зашифрованного текста. " +
                "Столбец, в котором находится данный символ, соответствует первому символу исходного текста. " +
                "Следующие символы зашифрованного текста расшифровываются подобным образом.");
        aboutVigenereCipher.setEditable(false);
        aboutVigenereCipher.setLineWrap(true);
        aboutVigenereCipher.setWrapStyleWord(true);
        aboutVigenereCipher.setOpaque(false);
        aboutVigenereCipher.setFont(myFont.getFont());

        jbtnBack = new JButton("Назад");
        jbtnBack.addActionListener(new Listener());
        jbtnBack.setFocusable(false);
        jbtnBack.setFont(myFont.getFont());

        add(new JLabel(imageIconSquare), BorderLayout.WEST);
        add(new JScrollPane(aboutVigenereCipher), BorderLayout.CENTER);
        add(jbtnBack, BorderLayout.SOUTH);
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
