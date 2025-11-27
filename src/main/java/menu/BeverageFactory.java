package menu;

import beverage.*;

public class BeverageFactory {

    public static Beverage create(BeverageType type) {
        return switch (type) {
            case Кофе -> new Coffee();
            case Чай ->  new Tea();
        };
    }
}
