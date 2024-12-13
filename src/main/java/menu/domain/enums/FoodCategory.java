package menu.domain.enums;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public enum FoodCategory {
    JAPANESE("일식"),
    KOREAN("한식"),
    CHINESE("중식"),
    ASIAN("아시안"),
    WESTERN("양식");

    private final String name;

    FoodCategory(String name) {
        this.name = name;
    }

    public static FoodCategory pickRandom() {
        List<FoodCategory> foodCategories = List.of(FoodCategory.values());
        return foodCategories.get(Randoms.pickNumberInRange(1, 5) - 1);
    }

    public String getName() {
        return name;
    }
}
