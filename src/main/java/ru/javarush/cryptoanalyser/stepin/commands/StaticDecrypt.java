package ru.javarush.cryptoanalyser.stepin.commands;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class StaticDecrypt implements Action {
    private final Scanner scanner = new Scanner(System.in);

    private final Map<Character, Integer> mapEncryptedFile;
    private final Map<Character, Integer> mapStatisticFile;
    private final Map<Character, Character> mapDeEncrypted;

    public StaticDecrypt() {
        mapEncryptedFile = new HashMap<>();
        mapStatisticFile = new HashMap<>();
        mapDeEncrypted = new HashMap<>();
    }

    @Override
    public void execute() throws IOException {

        System.out.println("Введите полный путь к файлу, для его расшифровки:");
        String pathEncryptedFile = scanner.nextLine();

        System.out.println("Введите полный путь к файлу, для набора статистики:");
        String pathStatisticFile  = scanner.nextLine();

        System.out.println("Введите полный путь к файлу, в который записать расшифрованый текст:");
        String pathNotEncryptedFile = scanner.nextLine();

        List<Map.Entry<Character, Integer>> listEncryptedFile = fillMapValues(mapEncryptedFile, pathEncryptedFile);
        List<Map.Entry<Character, Integer>> listStatisticFile = fillMapValues(mapStatisticFile, pathStatisticFile);

        if (listEncryptedFile.size() <= listStatisticFile.size() ) {
            for (int i = 0; i < listEncryptedFile.size(); i++) {
                mapDeEncrypted.put(listEncryptedFile.get(i).getKey(), listStatisticFile.get(i).getKey());
            }
            try (BufferedReader reader = Files.newBufferedReader(Paths.get(pathEncryptedFile));
                 BufferedWriter writer = Files.newBufferedWriter(Paths.get(pathNotEncryptedFile))) {
                while (reader.ready()) {
                    String string = reader.readLine();
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < string.length(); i++) {
                        char encryptedChar = string.charAt(i);
                        Character deEncryptedChar = mapDeEncrypted.get(encryptedChar);
                        stringBuilder.append(deEncryptedChar);
                    }
                    writer.write(stringBuilder + System.lineSeparator());
                }
            }
            System.out.println("Содержимое файла расшифровано методом статистического анализа.");
        } else {
            System.out.println("Размер файла статистики недостаточен для расшифровки, необходим файл большей длины чем зашифрованный");
        }
    }

    private List<Map.Entry<Character, Integer>> fillMapValues(Map<Character, Integer> map, String path) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
            while (reader.ready()) {
                String string = reader.readLine();
                stringBuilder.append(string);
            }
            String bigString = stringBuilder.toString();
            for (int i = 0; i < bigString.length(); i++) {
                char charAt = bigString.charAt(i);
                if (!map.containsKey(charAt)) {
                    map.put(charAt, 1);
                } else {
                    map.put(charAt, map.get(charAt) + 1);
                }
            }

            List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());

            Comparator<Map.Entry<Character, Integer>> comparator = Map.Entry.comparingByValue();

            list.sort(comparator.reversed());

            return list;
        }
    }
}
