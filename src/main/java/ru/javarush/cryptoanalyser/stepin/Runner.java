package ru.javarush.cryptoanalyser.stepin;

import ru.javarush.cryptoanalyser.stepin.toplevel.Application;
import ru.javarush.cryptoanalyser.stepin.controller.MainController;
import ru.javarush.cryptoanalyser.stepin.entity.Result;

public class Runner {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        Application application = new Application(mainController);
        Result result = application.run(args);
        System.out.println(result);
    }
}
