package menu.domain.enums;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Food {
    // JAPANESE
    GYUDONG("규동", FoodCategory.JAPANESE),
    UDONG("우동", FoodCategory.JAPANESE),
    MISOSIRU("미소시루", FoodCategory.JAPANESE),
    SUSHI("스시", FoodCategory.JAPANESE),
    GATSDONG("가츠동", FoodCategory.JAPANESE),
    ONIGIRI("오니기리", FoodCategory.JAPANESE),
    HIRICE("하이라이스", FoodCategory.JAPANESE),
    RAMEN("라멘", FoodCategory.JAPANESE),
    OKONOMIYAKKI("오코노미야끼", FoodCategory.JAPANESE),

    // KOREAN
    KIMBAB("김밥", FoodCategory.KOREAN),
    KIMCHI_SOUP("김치찌개", FoodCategory.KOREAN),
    SSAMBAB("쌈밥", FoodCategory.KOREAN),
    DUENJANG_SOUP("된장찌개", FoodCategory.KOREAN),
    BIBIMBAB("비빔밥", FoodCategory.KOREAN),
    KALGUKSU("칼국수", FoodCategory.KOREAN),
    BULGOGI("불고기", FoodCategory.KOREAN),
    DDUKBOKI("떡볶이", FoodCategory.KOREAN),
    JEYUK_BBOKUM("제육볶음", FoodCategory.KOREAN),

    // CHINESE
    KKANPUNGI("깐풍기", FoodCategory.CHINESE),
    BOOKUMMEON("볶음면", FoodCategory.CHINESE),
    DONGPAYUK("동파육", FoodCategory.CHINESE),
    JJAJANGMEON("짜장면", FoodCategory.CHINESE),
    JJAMPPONG("짬뽕", FoodCategory.CHINESE),
    MAPA_DUBU("마파두부", FoodCategory.CHINESE),
    TANGSUYUK("탕수육", FoodCategory.CHINESE),
    TOMATO_EGG_BBOKUM("토마토 달걀볶음", FoodCategory.CHINESE),
    GOCHU_JAPCHE("고추잡채", FoodCategory.CHINESE),

    POTTAI("팟타이", FoodCategory.ASIAN),
    KAO_POT("카오 팟", FoodCategory.ASIAN),
    NASIGORANG("나시고렝", FoodCategory.ASIAN),
    PINEAPPLE_BBOKUM("파인애플 볶음밥", FoodCategory.ASIAN),
    RICE_NOODLE("쌀국수", FoodCategory.ASIAN),
    DDOMYANGGUNG("똠양꿍", FoodCategory.ASIAN),
    BANMHI("반미", FoodCategory.ASIAN),
    WALNAMSSAM("월남쌈", FoodCategory.ASIAN),
    BBUNJJA("분짜", FoodCategory.ASIAN),

    // WESTERN
    LAJANYA("라자냐", FoodCategory.WESTERN),
    GRATANG("그라탱", FoodCategory.WESTERN),
    NYOKKI("뇨끼", FoodCategory.WESTERN),
    KKISU("끼슈", FoodCategory.WESTERN),
    FRENCH_TOAST("프렌치 토스트", FoodCategory.WESTERN),
    BAGGUETE("바게트", FoodCategory.WESTERN),
    SPAGGETI("스파게티", FoodCategory.WESTERN),
    PIZZA("피자", FoodCategory.WESTERN),
    PANINI("파니니", FoodCategory.WESTERN);

    private final String name;
    private final FoodCategory foodCategory;

    Food(String name, FoodCategory foodCategory) {
        this.name = name;
        this.foodCategory = foodCategory;
    }

    public static Food findFrom(String foodName) {
        for (Food food : Food.values()) {
            if (foodName.equals(food.name)) {
                return food;
            }
        }

        throw new IllegalArgumentException("같은 이름의 메뉴를 찾을 수 없습니다.");
    }

    public static Food pickRandomFrom(FoodCategory foodCategory) {
        List<Food> targetFoods = Arrays.stream(Food.values()).
                filter(food -> food.foodCategory.equals(foodCategory)).
                collect(Collectors.toList());

        return Randoms.shuffle(targetFoods).get(0);
    }

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }

    public String getName() {
        return name;
    }
}
