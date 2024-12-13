package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.domain.enums.Food;

public class Coach {
    private final String name;

    private final List<Food> hateFoods;

    private Coach(String name, List<Food> hateFoods) {
        validate(name);
        this.name = name;
        this.hateFoods = hateFoods;
    }

    public static Coach makeFrom(String name) {
        return new Coach(name, new ArrayList<>());
    }

    public void addHateFoods(List<Food> hateFoods) {
        this.hateFoods.addAll(hateFoods);
    }

    private void validate(String name) {
        if (!(name.length() >= 2 && name.length() <= 4)) {
            throw new IllegalArgumentException("코치 이름은 최소 2글자 최대 4글자입니다.");
        }
    }

    public String getName() {
        return name;
    }
}
