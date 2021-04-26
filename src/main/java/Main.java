import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    public static void task1() {
        try {
            BufferedReader bufferedFile = new BufferedReader(new FileReader("file.txt"));
            String line;
            while ((line = bufferedFile.readLine()) != null) {
                printPhone(line);
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    //Дополнительный метод для задания №1
    public static void printPhone(String phone) {
        if (verificationOfPhone(phone)) System.out.println(phone);

    }

    //Дополнительный метод для задания №1
    public static boolean verificationOfPhone(String phone) {
        char[] arr = phone.toCharArray();
        if (arr.length == 14 && arr[0] == '(' && arr[4] == ')' && arr[5] == ' ' && arr[9] == '-') return true;
        else return arr.length == 12 && arr[3] == '-' && arr[7] == '-';
    }


    public static void task2() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Нужно указать актуальные пути к файлам для проверки задания
        try (BufferedReader list = new BufferedReader(new FileReader("C:\\Users\\vgavr\\IdeaProjects\\untitled1\\file.txt"));
             BufferedWriter writerJson = new BufferedWriter(new FileWriter("C:\\Users\\vgavr\\IdeaProjects\\untitled1\\user.json"))
        ) {
            String[] arr;
            List<String> myList = new ArrayList<>();
            String line = list.readLine();
            while ((line = list.readLine()) != null) {
                arr = line.split(" ");
                myList.add(gson.toJson(new User(arr[0], Integer.parseInt(arr[1]))));
            }
            writerJson.write(myList.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Задание 3 решил вынести в отдельный класс
    public static void task3() {
        // Нужно указать актуальные пути к файлам для проверки задания
        UniqueWords.getInstance(new File("C:\\Users\\vgavr\\IdeaProjects\\untitled1\\words.txt"));
        UniqueWords.printSortWords();


    }
}

