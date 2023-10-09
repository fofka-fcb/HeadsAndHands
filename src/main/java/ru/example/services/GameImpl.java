package ru.example.services;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import ru.example.domain.Hero;
import ru.example.domain.Monster;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import static java.lang.System.out;

@RequiredArgsConstructor
public class GameImpl implements Game {
    private final MenuImpl menu;

    @SneakyThrows
    public synchronized void start() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Hero hero = new Hero();
        Monster monster = new Monster();
        List<Integer> listOfLvl = new LinkedList();
        for (int j = 1; j < 4; j++) {
            listOfLvl.add(j);
        }

        out.println();
        out.println("После долгого похода вы наконец-то вышли на след чудовищ");
        wait(3000L);
        out.println("Следы ведут в одну из пещер... Надо посетить ее");
        wait(3000L);
        out.println("О нет, тут все кешит монстрами!");
        wait(3000L);

        Battle battle = new BattleImpl(hero, monster, reader, menu);

        for (int lvl : listOfLvl) {
            if (lvl == 1) {
                out.println("Один из них бежит прямо на меня");
                wait(3000L);
                out.println();
                out.println("Сражение началось!");
                hero.setHealth(100);
                hero.setDamage(2);
                monster.setHealth(100);
                monster.setDamage(2);
                out.println("Ваше здоровье = " + hero.getHealth() + " и ваш урон = " + hero.getDamage());
                out.println("Здоровье монстра = " + monster.getHealth() + " и его урон = " + monster.getDamage());
                if (!battle.game()) {
                    if (hero.getHealth() < 0) {
                        out.println("Увы, одолеть монстра не удалось, вы пали смертью храбрых(");
                        menu.listOfResults.clear();
                        break;
                    }
                    out.println("Увы, одолеть монстра не удалось, вы трусливо убежали");
                    break;
                }
            } else if (lvl == 2) {
                out.println();
                out.println("Сюда бежит еще один монстр");
                out.println("Будь аккуратнее, Герой, сложность повысилась");
                wait(3000L);
                out.println();
                out.println("Сражение началось!");
                hero.setHealth(100);
                hero.setDamage(3);
                monster.setHealth(100);
                monster.setDamage(4);
                out.println("Ваше здоровье = " + hero.getHealth() + " и ваш урон = " + hero.getDamage());
                out.println("Здоровье монстра = " + monster.getHealth() + " и его урон = " + monster.getDamage());
                if (!battle.game()) {
                    if (hero.getHealth() < 0) {
                        out.println("Увы, одолеть монстра не удалось, вы пали смертью храбрых(");
                        menu.listOfResults.clear();
                        break;
                    }
                    out.println("Увы, одолеть монстра не удалось, вы трусливо убежали");
                    break;
                }
            } else if (lvl == 3) {
                out.println();
                out.println("Сюда бежит последний монстр");
                out.println("Будь аккуратнее, Герой, сложность повысилась");
                wait(3000L);
                out.println();
                out.println("Сражение началось!");
                hero.setHealth(100);
                hero.setDamage(5);
                monster.setHealth(100);
                monster.setDamage(6);
                out.println("Ваше здоровье = " + hero.getHealth() + " и ваш урон = " + hero.getDamage());
                out.println("Здоровье монстра = " + monster.getHealth() + " и его урон = " + monster.getDamage());
                if (!battle.game()) {
                    if (hero.getHealth() < 0) {
                        out.println("Увы, одолеть монстра не удалось, вы пали смертью храбрых(");
                        menu.listOfResults.clear();
                        break;
                    }
                    out.println("Увы, одолеть монстра не удалось, вы трусливо убежали");
                    break;
                }
                out.println();
                wait(3000L);
                out.println("Поздравляю, пещера с монстрами зачищена!");
                out.println("Теперь можно вернуться домой и отдохнуть");
            }
        }
    }
}

