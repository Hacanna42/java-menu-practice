package menu.view;

import java.util.List;
import java.util.Map;
import menu.dto.RecommendResultDto;

public class OutputView {
    public static void printStartServiceMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public static void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }

    public static void printResult(RecommendResultDto recommendResultDto) {
        String parsedCategories = String.join(" | ", recommendResultDto.getSelectedCategories());
        System.out.println();
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.printf("[ 카테고리 | %s ]%n", parsedCategories);

        for (Map.Entry<String, List<String>> entry : recommendResultDto.getSelectedMenusPerCoach().entrySet()) {
            String parsedMenus = String.join(" | ", entry.getValue());
            System.out.printf("[ %s | %s ]%n", entry.getKey(), parsedMenus);
        }

        System.out.println("\n추천을 완료했습니다.");
    }
}
