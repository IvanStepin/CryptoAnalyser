package ru.javarush.cryptoanalyser.stepin.commands;

import ru.javarush.cryptoanalyser.stepin.entity.Result;
import ru.javarush.cryptoanalyser.stepin.entity.ResultCodeEnum;
import ru.javarush.cryptoanalyser.stepin.exceptions.ApplicationException;
import ru.javarush.cryptoanalyser.stepin.util.PathFinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static ru.javarush.cryptoanalyser.stepin.constants.Strings.ALPHABET;

public class Encoder implements Action{
    @Override
    public Result execute(String[] parameters) {
        String encryptedFile = parameters[1];
        int key = Integer.parseInt(parameters[2]);
        
        Path path = Path.of(PathFinder.getRoot()+encryptedFile);
        try {
            String string = Files.readString(path);
            encrypt(string, key);
        } catch (IOException e) {
            throw new ApplicationException("IO error", e);
        }
        return new Result(ResultCodeEnum.OK, "read all bytes" + path);
    }
    String encrypt(String message, int key) {

        StringBuilder result = new StringBuilder();

        for (char aChar : message.toCharArray()) {

            int origAlphabetPos = ALPHABET.indexOf(aChar);

            int newAlphabetPos;
            char newCharacter = 0;

            if (origAlphabetPos >= 0) {
                if (key >= 0) {
                    newAlphabetPos = (origAlphabetPos + key) % (ALPHABET.length());
                } else {
                    int newKey = key % (ALPHABET.length());
                    newAlphabetPos = (origAlphabetPos + (ALPHABET.length()) + newKey) % ALPHABET.length();
                }
                newCharacter = ALPHABET.charAt(newAlphabetPos);
            }
            result.append(newCharacter);
        }
        return result.toString();
    }
}