package ru.example.domain;

import lombok.*;

import java.util.concurrent.ThreadLocalRandom;

@Data
public class Creature {
    private int health;
    private int damage;

    public int attack(int damage) {
        int min = 1, max = 6;
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        return damage * randomNum;
    }

}
