package menu.view;

public class OutputView {
    public static void printStartServiceMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public static void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }
}
