package ru.example.services;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import ru.example.domain.Hero;
import ru.example.domain.Monster;

import java.io.BufferedReader;

import static java.lang.System.out;

@RequiredArgsConstructor
public class BattleImpl implements Battle {
    private final Hero hero;
    private final Monster monster;
    private final BufferedReader reader;
    private final MenuImpl menu;

    @Override
    @SneakyThrows
    public boolean game() {
        boolean win = false;

        for (int i = 0; i < 4; i++) hero.listOfHealing.add("flask");
        monster.listOfDamage.add("damage");

        while (true) {
            if (monster.getHealth() < 50 && monster.listOfDamage.size() == 1) {
                out.println("Урон монстра повышен на 50%, будь аккуратнее, Герой");
                monster.setDamage((int) (monster.getDamage() * 1.5));
                monster.listOfDamage.add("damage1");
            }
            out.println("Нажмите '1' чтобы атаковать монстра");
            out.println("Нажмите '2' чтобы выпить зелье лечения. Количество зелий: " + hero.listOfHealing.size());
            out.println("Нажмите '3' чтобы выйти в меню и завершить сражение с монстром");
            String numOfSpell = reader.readLine();
            if (numOfSpell.startsWith("1")) {
                int hpMonster = monster.getHealth();
                monster.setHealth(monster.getHealth() - hero.attack(hero.getDamage()));
                out.println("Вы атаковали монстра на (" + (hpMonster - monster.getHealth()) + ") урона");

                int hpHero = hero.getHealth();
                hero.setHealth(hero.getHealth() - monster.attack(monster.getDamage()));
                out.println("Монстр нанес удар в ответ на (" + (hpHero - hero.getHealth()) + ") урона");
            } else if (numOfSpell.startsWith("2")) {
                if (!hero.listOfHealing.isEmpty()) {
                    hero.setHealth(Math.min(hero.getHealth() + hero.healing(), 100));
                    hero.listOfHealing.remove(0);
                    out.println("Зелье применено");
                } else {
                    out.println("Зелий не осталось");
                }
            } else if (numOfSpell.startsWith("3")) {
                break;
            }

            if (monster.getHealth() <= 0) {
                out.println("Поздравляю, вы убили монстра!");
                menu.listOfResults.add("monster");
                win = true;
                break;
            } else if (hero.getHealth() <= 0) {
                break;
            }

            out.println("Ваше здоровье = " + hero.getHealth());
            out.println("Здоровье монстра = " + monster.getHealth());
            out.println();
        }
        hero.listOfHealing.clear();
        return win;
    }
}
