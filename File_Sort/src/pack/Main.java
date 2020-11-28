package pack;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String words;
        Map<String, Integer> treeWords;
        Scanner scan = new Scanner(System.in);
        File_Reader reader1 = new File_Reader();
        System.out.println("Введите имя файла или путь к нему: ");

        words = File_Reader.readerMethod(scan.nextLine()); // получение строки с текстом из файла
        String[] arrayWords = words.split(" +|\0+|\t+|\n+|\\.+|,+|!+|:+|;+|\\?+|-+|\\(+|\\)+|\\[+|\\]"); // разделение на слова и заполнение массива
        treeWords = fillTreeMap(arrayWords);
        showAllWords(treeWords); // вывод всех слов с количеством их повторений
        showMaxKey(treeWords); // вывод слов(а), встречающегося чаще остальных
    }

    public static Map<String, Integer> fillTreeMap(String[] arrayWords) {
        int j = 1;
        Map<String, Integer> treeWords = new TreeMap<>();
        for (String word : arrayWords) {
            if (treeWords.get(word) != null) {
                treeWords.put(word, treeWords.get(word) + 1);
            } else if (word != ""){
                treeWords.put(word, j);
            }
        }
        return treeWords;
    }

    public static void showAllWords(Map<String, Integer> someTree){
        if (someTree.isEmpty()) {
            System.out.println("Пустой файл.");
        }
        for (Map.Entry<String, Integer> entry : someTree.entrySet())
            System.out.println(entry.getKey() + " : " + entry.getValue());
    }

    public static void showMaxKey(Map<String, Integer> someTree){
        int i = -1;
        String key = null;
        for (Map.Entry<String, Integer> entry : someTree.entrySet()){
            if (i <= entry.getValue()) {
                i = entry.getValue();
                key = entry.getKey();
            }
        }
        for (Map.Entry<String, Integer> entry : someTree.entrySet()){
            if (i == entry.getValue()){
                System.out.println("Max ---> " + entry.getKey() + " : " + entry.getValue());
            }
        }
    }
}

