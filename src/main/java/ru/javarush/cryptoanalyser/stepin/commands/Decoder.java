package ru.javarush.cryptoanalyser.stepin.commands;

import ru.javarush.cryptoanalyser.stepin.entity.Result;
import ru.javarush.cryptoanalyser.stepin.entity.ResultCodeEnum;
import ru.javarush.cryptoanalyser.stepin.exceptions.ApplicationException;
import ru.javarush.cryptoanalyser.stepin.util.PathFinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Decoder implements Action {
    @Override
    public Result execute(String[] parameters) {
        String decriptedFile = parameters[1];
        int key = Integer.parseInt(parameters[2]);

        Path path = Path.of(PathFinder.getRoot() + decriptedFile);
        try {
            String string = Files.readString(path);
            deEncrypt(string, key);
        } catch (IOException e) {
            throw new ApplicationException("IO error", e);
        }
        return new Result(ResultCodeEnum.OK, "read all bytes" + path);
    }

    public String deEncrypt(String message, int key) {
        Encoder encoder = new Encoder();
        return encoder.encrypt(message, key * (-1));
    }
}

