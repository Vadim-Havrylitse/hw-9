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
        InputStream resourceFileTask1 = Main.class.getResourceAsStream("/file.txt");

        try (BufferedReader bufferedFile = new BufferedReader(new InputStreamReader(resourceFileTask1))) {
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
        InputStream file2 = Main.class.getResourceAsStream("/file2.txt");
        try (BufferedReader list = new BufferedReader(new InputStreamReader(file2));
             BufferedWriter writerJson = new BufferedWriter(new FileWriter("user.json"))) {
            String[] arr;
            List<String> myList = new ArrayList<>();
            String line = list.readLine();
            while ((line = list.readLine()) != null) {
                arr = line.split(" ");
                myList.add(gson.toJson(new User(arr[0], Integer.parseInt(arr[1]))));
            }
            writerJson.write(myList.toString());

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    // Задание 3 решил вынести в отдельный класс
    public static void task3() {
        InputStream file2 = Main.class.getResourceAsStream("/words.txt");
        UniqueWords.getInstance(file2);
        UniqueWords.printSortWords();


    }
}

