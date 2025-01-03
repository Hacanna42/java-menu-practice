package menu.controller;

import java.util.List;
import menu.domain.Coach;
import menu.domain.enums.Food;
import menu.dto.RecommendResultDto;
import menu.service.MenuService;
import menu.util.Parser;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    public void run() {
        OutputView.printStartServiceMessage();
        List<Coach> coaches = getCoaches();
        applyHateFoods(coaches);
        RecommendResultDto recommendResultDto = menuService.processRecommend(coaches);
        OutputView.printResult(recommendResultDto);
    }

    private List<Coach> getCoaches() {
        while (true) {
            try {
                return Parser.parseCoaches(InputView.getCoachesName());
            } catch (IllegalArgumentException exception) {
                OutputView.printErrorMessage(exception.getMessage());
            }
        }
    }

    private void applyHateFoods(List<Coach> coaches) {
        coaches.forEach(coach -> coach.addHateFoods(getHateFood(coach)));
    }

    private List<Food> getHateFood(Coach coach) {
        while (true) {
            try {
                return Parser.parseMenus(InputView.getHateMenusName(coach.getName()));
            } catch (IllegalArgumentException exception) {
                OutputView.printErrorMessage(exception.getMessage());
            }
        }
    }
}
