package ru.javarush.cryptoanalyser.stepin.constants;

import java.util.HashMap;
import java.util.Map;

public class Strings {
    private static final String rus = "йцукенгшщзхъфывапролджэячсмитьбю";
    private static final String eng = "qwertyuiopasdfghjklzxcvbnm";
    private static final String cyphers = "1234567890";
    private static final String symbols = ",./@#$%^!_-+=\\|&*(){}[];:'";
    public static final char [] ALPHABET = (rus + rus.toUpperCase() + eng + eng.toUpperCase() + cyphers + symbols).toCharArray();
    public static final Map<Character, Integer> index = new HashMap<>();

    static {
        for (int i=0; i<ALPHABET.length; i++){
            index.put(ALPHABET[i], i);
        }
    }
}
