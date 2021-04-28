import java.io.*;
import java.util.*;

public final class UniqueWords {
    public static HashMap<String, Integer> words = new HashMap<>();


    private UniqueWords() {
    }


    public static void getInstance(InputStream file) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file))) {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                if (str.strip().equals("") || str.strip().equals(" ")) {
                    continue;
                }
                int index = 0;
                for (int i = str.indexOf(' ', index); i > 0; i = str.indexOf(' ', index)) {
                    if (str.equals(" ")) {
                        continue;
                    }
                    String ourWord = str.substring(index, i);
                    checkWord(ourWord);
                    index = i + 1;
                }
                checkWord(str.substring(str.lastIndexOf(" ") + 1));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    public static void checkWord(String ourWord) {
        if (words.containsKey(ourWord)) {
            words.put(ourWord, words.get(ourWord) + 1);
        } else {
            words.put(ourWord, 1);
        }
    }

    public static void printSortWords() {
        List list = new ArrayList(words.entrySet());
        Collections.sort(list, (Comparator<Map.Entry<String, Integer>>) (o1, o2) -> {
            if (o1.getValue() == o2.getValue()) {
                return o1.getKey().length() - o2.getKey().length();
            }
            return o2.getValue() - o1.getValue();
        });

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


    }

}
