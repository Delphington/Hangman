package backend.academy.data;

import backend.academy.info.StringConst;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WordCategory implements StringConst {
    SPORT("Спорт"),
    ANIMAL("Животные"),
    NATURE("Природа"),
    COUNTRY("Страны");
    private final String description;
}
