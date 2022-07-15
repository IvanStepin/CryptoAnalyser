package ru.javarush.cryptoanalyser.stepin.controller;

import ru.javarush.cryptoanalyser.stepin.commands.Action;
import ru.javarush.cryptoanalyser.stepin.commands.Decoder;
import ru.javarush.cryptoanalyser.stepin.commands.Encoder;

public enum Actions {
    ENCODE(new Encoder()),
    DECODE(new Decoder());

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String command) {
        return Actions.valueOf(command.toUpperCase()).action;
    }
}
