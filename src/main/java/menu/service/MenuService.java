package menu.service;

import java.util.List;
import menu.domain.Coach;
import menu.domain.RecommendResult;
import menu.domain.enums.DayOfWeek;
import menu.domain.enums.Food;
import menu.domain.enums.FoodCategory;
import menu.dto.RecommendResultDto;

public class MenuService {
    private final RecommendResult recommendResult;

    public MenuService() {
        this.recommendResult = new RecommendResult();
    }

    public RecommendResultDto processRecommend(List<Coach> coaches) {
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            recommendFrom(coaches, dayOfWeek);
        }

        return recommendResult.getRecommendResultDto();
    }

    private void recommendFrom(List<Coach> coaches, DayOfWeek dayOfWeek) {
        FoodCategory selectedCategory = pickFoodCategory();

        for (Coach coach : coaches) {
            Food selectedMenu = pickMenu(selectedCategory, coach);
            coach.addHateFoods(List.of(selectedMenu));
            recommendResult.addResult(dayOfWeek, coach, selectedMenu);
        }
    }

    private static Food pickMenu(FoodCategory foodCategory, Coach coach) {
        Food selectedMenu = Food.pickRandomFrom(foodCategory);
        while (!coach.canApplyFood(selectedMenu)) {
            selectedMenu = Food.pickRandomFrom(foodCategory);
        }

        return selectedMenu;
    }

    private FoodCategory pickFoodCategory() {
        FoodCategory selectedCategory = FoodCategory.pickRandom();
        while (!recommendResult.canApplyCategory(selectedCategory)) {
            selectedCategory = FoodCategory.pickRandom();
        }

        return selectedCategory;
    }
}
