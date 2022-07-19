package ru.javarush.cryptoanalyser.stepin.constants;

import java.util.HashMap;
import java.util.Map;

public class Strings {
    public static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя" +
            ".,\":-!? +-*/\\@#$%^&(){}[];'|`~=_©«»—0123456789";

    public int alphabetLength() {
        return ALPHABET.length();
    }
}
