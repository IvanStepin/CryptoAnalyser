package ru.javarush.cryptoanalyser.stepin.controller;

import ru.javarush.cryptoanalyser.stepin.commands.Action;
import ru.javarush.cryptoanalyser.stepin.entity.Result;
import ru.javarush.cryptoanalyser.stepin.entity.ResultCodeEnum;
import ru.javarush.cryptoanalyser.stepin.exceptions.ApplicationException;

public class MainController {
    public Result execute(String command, String[] parameters) {
        try {
            Action action = ActionContainer.find(command);
            return action.execute(parameters);
        }catch (NumberFormatException | ApplicationException e){
            return new Result(ResultCodeEnum.ERROR, e.getMessage());
        }
    }
}
