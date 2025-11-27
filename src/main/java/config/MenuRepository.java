package config;

import menu.BeverageType;
import java.util.Arrays;
import java.util.List;

public class MenuRepository {

    private static MenuRepository instance;

    private MenuRepository() {}

    public static MenuRepository getInstance() {
        if (instance == null) {
            instance = new MenuRepository();
        }
        return instance;
    }

    public List<BeverageType> getMenu() {
        return Arrays.asList(BeverageType.values());
    }
}
