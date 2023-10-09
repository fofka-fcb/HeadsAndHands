package ru.example;

import ru.example.services.Menu;
import ru.example.services.MenuImpl;

import static java.lang.System.out;

public class Application {

    public static void main(String[] args) {
        out.println();
        out.println("Добро пожаловать в игру");
        Menu menu = new MenuImpl();
        menu.start();
    }

}