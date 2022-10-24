package project.Entity;

import project.GUI.AppGUI;
/**
 * class, realizing the Vigener cipher
 *
 * @author Sachkova E. D.
 */
public class VigenereCoder {
    private String alphabet;
    private String alphabetUpperCase;
    private final String ALPHABET_RU ="абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private final String ALPHABET_UPPER_CASE_RU ="АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private final int RU =33;
    private final String ALPHABET_ENG ="abcdefghijklmnopqrstuvwxyz";
    private final String ALPHABET_UPPER_CASE_ENG ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final int ENG =26;
    String rez="";
    int k=0;
    int c;
    int a, b;
    int number;

    public VigenereCoder(){};
 /** Vigenere coder*/
    public String vigenereCoder(String word, String text){
        choseAlpabet();
        if (checkSpecialWordLanguage(word))
        for(int i=0;i<text.length();i++) {
            if (alphabet.indexOf(text.charAt(i)) == -1 && alphabetUpperCase.indexOf(text.charAt(i)) == -1)
                rez = rez + text.charAt(i);
            else {
                if (k >= word.length() && k!=0) k = 0;
                a = alphabet.indexOf(word.charAt(k));
                if (a==-1) a = alphabetUpperCase.indexOf(word.charAt(k));
                b = alphabet.indexOf(text.charAt(i));
                if (b==-1) b = alphabetUpperCase.indexOf(text.charAt(i));
                k++;
                c = a + b;
                while (c >= alphabet.length()) c = a + b - number;
                rez = rez + alphabet.charAt(c);
            }}
        else rez = "Ошибка секретного слова! Введены символы не того языка! Проверьте язык или измените секретное слово! " +
                "Также убедитесь, что отсутствуют знаки препинания и пробелы.";
        return rez;
    }
    /** Vigenere decoder*/
    public String vigenereDecoder(String word, String text){
        choseAlpabet();
        if (checkSpecialWordLanguage(word))
            for(int i=0;i<text.length();i++) {
                if (alphabet.indexOf(text.charAt(i)) == -1 && alphabetUpperCase.indexOf(text.charAt(i)) == -1)
                    rez = rez + text.charAt(i);
                else {
                    if (k >= word.length() && k!=0) k = 0;
                    a = alphabet.indexOf(word.charAt(k));
                    if (a==-1) a = alphabetUpperCase.indexOf(word.charAt(k));
                    b = alphabet.indexOf(text.charAt(i));
                    if (b==-1) b = alphabetUpperCase.indexOf(text.charAt(i));
                    k++;
                    c = b-a;
                    while (c < 0) c = c + number;
                    rez = rez + alphabet.charAt(c);
                }}
        else rez = "Ошибка секретного слова! Введены символы не того языка! Проверьте язык или измените секретное слово! " +
                "Также убедитесь, что отсутствуют знаки препинания и пробелы.";
        return rez;
    }
/**method for choose ru or eng alphabet*/
    public void choseAlpabet(){
        if (AppGUI.getLanguage()==0){
            alphabet = ALPHABET_RU;
            alphabetUpperCase= ALPHABET_UPPER_CASE_RU;
            number= RU;
        }
        if (AppGUI.getLanguage()==1){
            alphabet = ALPHABET_ENG;
            alphabetUpperCase= ALPHABET_UPPER_CASE_ENG;
            number= ENG;
        }
    }
/**check special word for the presence of invalid characters */
    public boolean checkSpecialWordLanguage(String word){
        for (int i=0;i<word.length();i++){
            if (alphabet.indexOf(word.charAt(i)) == -1 && alphabetUpperCase.indexOf(word.charAt(i)) == -1)
                return false;
        }
        return true;
    }
}
