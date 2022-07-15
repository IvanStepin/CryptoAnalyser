package ru.javarush.cryptoanalyser.stepin.controller;

import ru.javarush.cryptoanalyser.stepin.commands.Action;
import ru.javarush.cryptoanalyser.stepin.entity.Result;
import ru.javarush.cryptoanalyser.stepin.entity.ResultCode;
import ru.javarush.cryptoanalyser.stepin.exceptions.ApplicationException;

public class MainController {
    public Result execute(String command, String[] parameters) {
        try {
            Action action = Actions.find(command);
            return action.execute(parameters);
        }catch (ApplicationException e){
            //TODO lof file for exception
            return new Result(ResultCode.ERROR, e.getMessage());
        }
    }
}
