package menu.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.domain.enums.DayOfWeek;
import menu.domain.enums.Food;
import menu.domain.enums.FoodCategory;
import menu.dto.RecommendResultDto;

public class RecommendResult {
    private static final int CATEGORY_DUPLICATE_LIMIT = 2;

    private final Map<DayOfWeek, Map<Coach, Food>> recommendResult;

    public RecommendResult() {
        this.recommendResult = new HashMap<>();
    }

    public boolean canApplyCategory(FoodCategory category) {
        int categoryAppliedCount = 0;
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if (!recommendResult.containsKey(dayOfWeek)) {
                continue;
            }

            Map<Coach, Food> selectedFood = recommendResult.get(dayOfWeek);
            FoodCategory foodCategory = getFoodCategoryFrom(selectedFood);
            if (foodCategory.equals(category)) {
                categoryAppliedCount++;
            }
        }

        return categoryAppliedCount < CATEGORY_DUPLICATE_LIMIT;
    }

    public void addResult(DayOfWeek dayOfWeek, Coach coach, Food food) {
        Map<Coach, Food> recommendedFoodPerCoach = recommendResult.getOrDefault(dayOfWeek, new HashMap<>());
        recommendedFoodPerCoach.put(coach, food);
        recommendResult.put(dayOfWeek, recommendedFoodPerCoach);
    }

    public RecommendResultDto getRecommendResultDto() {
        List<String> selectedCategoryNames = getSelectedCategoryNames();
        Map<String, List<String>> selectedMenusPerCoach = getSelectedMenusPerCoach();
        return new RecommendResultDto(selectedCategoryNames, selectedMenusPerCoach);
    }

    private List<String> getSelectedCategoryNames() {
        List<String> selectedCategoryNames = new ArrayList<>();
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if (!recommendResult.containsKey(dayOfWeek)) {
                throw new IllegalArgumentException("정상적인 동작이 아닙니다. getSelectedCategories() 메서드는 추천 결과가 모두 완성되었을 때 호출되어야 합니다.");
            }

            FoodCategory selectedFoodCategory = getFoodCategoryFrom(recommendResult.get(dayOfWeek));
            selectedCategoryNames.add(selectedFoodCategory.getName());
        }

        return selectedCategoryNames;
    }

    private Map<String, List<String>> getSelectedMenusPerCoach() {
        List<Coach> coaches = getCoaches();
        Map<String, List<String>> foodNamesPerCoach = new HashMap<>();
        for (Coach coach : coaches) {
            List<String> foodNames = getSelectedFoods(coach);
            foodNamesPerCoach.put(coach.getName(), foodNames);
        }

        return foodNamesPerCoach;
    }

    private List<String> getSelectedFoods(Coach coach) {
        List<String> foodNames = new ArrayList<>();
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            Map<Coach, Food> selectedFoodPerCoach = recommendResult.get(dayOfWeek);
            foodNames.add(selectedFoodPerCoach.get(coach).getName());
        }

        return foodNames;
    }

    private List<Coach> getCoaches() {
        List<Coach> coaches = new ArrayList<>();
        Map<Coach, Food> selectedFoodPerCoach = recommendResult.get(DayOfWeek.MON);
        for (Map.Entry<Coach, Food> entry : selectedFoodPerCoach.entrySet()) {
            coaches.add(entry.getKey());
        }

        return coaches;
    }

    public Map<DayOfWeek, Map<Coach, Food>> getRecommendResult() {
        return recommendResult;
    }

    private FoodCategory getFoodCategoryFrom(Map<Coach, Food> selectedFood) {
        for (Map.Entry<Coach, Food> entry : selectedFood.entrySet()) {
            return entry.getValue().getFoodCategory();
        }

        throw new IllegalArgumentException("음식 카테고리를 찾을 수 없습니다.");
    }
}
