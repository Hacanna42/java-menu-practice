package menu.view;

import java.util.Scanner;

public class InputView {
    public static String getCoachesName() {
        System.out.println();
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");

        // Console.readLine() 이 없어서 Scanner로 대체
        return new Scanner(System.in).nextLine();
    }

    public static String getHateMenusName(String who) {
        System.out.println();
        System.out.println(who + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        return new Scanner(System.in).nextLine();
    }
}
