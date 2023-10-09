package ru.example.services;

import lombok.SneakyThrows;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

import static java.lang.System.*;

public class MenuImpl implements Menu {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    List listOfResults = new LinkedList();

    @SneakyThrows
    public void start() {
        while (true) {
            out.println();
            out.println("Нажмите '1' чтобы отправиться на охоту на монстров");
            out.println("Нажмите '2' чтобы посмотреть свою статистику");
            out.println("Нажмите '3' чтобы выйти из игры");
            String numOfMenu = reader.readLine();
            if (numOfMenu.startsWith("1")) {
                Game game = new GameImpl(this);
                game.start();
            } else if (numOfMenu.startsWith("2")) {
                out.println();
                out.println("Количество убитых монстров = " + listOfResults.size());
            } else if (numOfMenu.startsWith("3")) {
                out.println();
                out.println("Спасибо что играли)");
                break;
            }
        }
    }
}
