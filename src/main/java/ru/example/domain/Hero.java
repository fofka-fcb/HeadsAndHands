package ru.example.domain;

import java.util.ArrayList;
import java.util.List;

public class Hero extends Creature {
    public List listOfHealing = new ArrayList();

    public int healing() {
        return 30;
    }
}
