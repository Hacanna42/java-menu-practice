package menu.util;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.domain.enums.Food;

public class Parser {
    public static List<Coach> parseCoaches(String input) {
        List<String> coachNames = List.of(input.split(","));
        List<Coach> coaches = new ArrayList<>();

        if (!(coachNames.size() >= 2 && coachNames.size() <= 5)) {
            throw new IllegalArgumentException("코치는 최소 2명, 최대 5명과 함께 식사해야 합니다.");
        }

        for (String name : coachNames) {
            coaches.add(Coach.makeFrom(name.trim()));
        }
        return coaches;
    }

    public static List<Food> parseMenus(String input) {
        List<String> menuNames = List.of(input.split(","));
        List<Food> foods = new ArrayList<>();

        if (menuNames.size() > 2) {
            throw new IllegalArgumentException("못 먹는 메뉴의 개수가 2개를 초과할 수 없습니다.");
        }

        for (String name : menuNames) {
            foods.add(Food.findFrom(name.trim()));
        }

        return foods;
    }
}
