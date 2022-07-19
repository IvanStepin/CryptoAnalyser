package ru.javarush.cryptoanalyser.stepin;


import ru.javarush.cryptoanalyser.stepin.commands.Decoder;
import ru.javarush.cryptoanalyser.stepin.commands.Encoder;
import ru.javarush.cryptoanalyser.stepin.controller.ActionContainer;
import ru.javarush.cryptoanalyser.stepin.toplevel.Application;
import ru.javarush.cryptoanalyser.stepin.controller.MainController;
import ru.javarush.cryptoanalyser.stepin.entity.Result;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("""

                                        Выберете действие, введя его номер:\s
                                        1. Зашифровать текст в файле с помощью ключа.\s
                                        2. Расшифровать текст в файле с помощью ключа.\s
                                        Для выхода из программы введите exit""");


            String  answer = reader.readLine();



            switch (answer) {
                case ("1") -> new Encoder().execute(args);
                case ("2") -> new Decoder().execute(args);
//                case ("3") -> new BruteForse().choiceThree();
//                case ("4") -> new ChoiceFour().choiceFour();
                default -> {
                    answer.equals("exit");
                    MainController mainController = new MainController();
                    Application application = new Application(mainController);
                    if (args.length == 0) {

                    }
                    Result result = application.run(args);
                    System.out.println(result);
                }
            }
        }
    }
}