import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        task1();
        //task2();
        //task3();
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
        boolean matches1 = phone.matches("[(]\\d{3}[)] \\d{3}[-]\\d{4}");
        boolean matches2 = phone.matches("\\d{3}-\\d{3}-\\d{4}");
        return matches1 || matches2;
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

