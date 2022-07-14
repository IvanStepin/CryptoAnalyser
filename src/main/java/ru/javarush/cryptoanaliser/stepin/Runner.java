package ru.javarush.cryptoanaliser.stepin;

import ru.javarush.cryptoanaliser.stepin.app.Application;
import ru.javarush.cryptoanaliser.stepin.controller.MainController;

public class Runner {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        Application application = new Application(mainController);
        Result result = application.run(args);
        System.out.println(result);
    }
}
