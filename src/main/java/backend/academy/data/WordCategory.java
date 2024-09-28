package backend.academy.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WordCategory  {
    SPORT("Спорт"),
    ANIMAL("Животные"),
    NATURE("Природа"),
    COUNTRY("Страны");
    private final String description;
}
