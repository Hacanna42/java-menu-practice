package menu.domain.enums;

public enum DayOfWeek {
    MON("월요일"),
    TUE("화요일"),
    WED("수요일"),
    THU("목요일"),
    FRI("금요일");

    private final String name;

    DayOfWeek(String name) {
        this.name = name;
    }
}
