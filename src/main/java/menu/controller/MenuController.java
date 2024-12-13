package menu.controller;

import java.util.List;
import menu.domain.Coach;
import menu.domain.enums.Food;
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
        coaches.forEach(coach -> coach.addHateFoods(getHateFood(coach)));
        menuService.processRecommend(coaches);
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

    private List<Food> getHateFood(Coach coach) {
        return Parser.parseMenus(InputView.getHateMenusName(coach.getName()));
    }
}
