package menu.dto;

import java.util.List;
import java.util.Map;

public class RecommendResultDto {
    private final List<String> selectedCategoryNames;
    private final Map<String, List<String>> selectedMenusPerCoach;

    public RecommendResultDto(List<String> selectedCategoryNames, Map<String, List<String>> selectedMenusPerCoach) {
        this.selectedCategoryNames = selectedCategoryNames;
        this.selectedMenusPerCoach = selectedMenusPerCoach;
    }

    public List<String> getSelectedCategories() {
        return selectedCategoryNames;
    }

    public Map<String, List<String>> getSelectedMenusPerCoach() {
        return selectedMenusPerCoach;
    }
}
