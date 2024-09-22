package backend.academy.data;

import backend.academy.info.StringConst;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WordCategory implements StringConst {
    SPORT(CATEGORY_SPORT),
    ANIMAL(CATEGORY_ANIMAL),
    NATURE(CATEGORY_NATURE),
    COUNTRY(CATEGORY_COUNTRY);


    private final String description;

}
