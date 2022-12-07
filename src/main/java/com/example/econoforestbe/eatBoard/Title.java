package com.example.econoforestbe.eatBoard;

import lombok.NoArgsConstructor;
import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
public class Title {
    private static final String NOT_EMPTY_TITLE = "제목은 비어있으면 안됩니다.";
    private String title;

    public Title(String title) {
        validationSize(title);
        this.title = title;
    }

    private void validationSize(String title) {
        if (title.isEmpty()) {
            throw new IllegalArgumentException(NOT_EMPTY_TITLE);
        }
    }
}
