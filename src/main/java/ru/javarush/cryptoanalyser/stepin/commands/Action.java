package ru.javarush.cryptoanalyser.stepin.commands;

import java.io.IOException;
public interface Action {
    void execute() throws IOException;
}
