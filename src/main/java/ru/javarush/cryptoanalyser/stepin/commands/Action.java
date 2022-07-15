package ru.javarush.cryptoanalyser.stepin.commands;

import ru.javarush.cryptoanalyser.stepin.entity.Result;

public interface Action {
    Result execute(String [] parameters);
}
